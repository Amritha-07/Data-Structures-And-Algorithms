class BTreeNode:
    def __init__(self, leaf = False):
        self.keys = []
        self.children = []
        self.leaf = leaf

class BTree:
    def __init__(self, t):
        self.t = t
        self.root = BTreeNode(True)

    def insert(self, value):
        root = self.root
        if len(root.keys) == (2 * self.t) - 1:
            temp = BTreeNode()
            self.root = temp
            temp.children.insert(0, root)
            self.splitChild(temp, 0)
            self.insertNotFull(temp, value)
        else:
            self.insertNotFull(root, value)

    def insertNotFull(self, root, value):
        i = len(root.keys) - 1
        if root.leaf:
            root.keys.append(None)
            while i >= 0 and value < root.keys[i]:
                root.keys[i + 1] = root.keys[i]
                i -= 1
            root.keys[i + 1] = value
        else:
            while i >= 0 and value < root.keys[i]:
                i -= 1
            i += 1
            if len(root.children[i].keys) ==  (2 * self.t) - 1:
                self.splitChild(root, i)
                if value > root.keys[i]:
                    i += 1
            self.insertNotFull(root.children[i], value)

    def splitChild(self, root, i):
        y = root.children[i]
        z = BTreeNode(leaf = y.leaf)
        root.children.insert(i + 1, z)
        root.keys.insert(i, y.keys[self.t - 1])
        z.keys = y.keys[self.t:]
        y.keys = y.keys[:self.t - 1]
        if not y.leaf:
            z.children = y.children[self.t:]
            y.children = y.children[:self.t]

    def deleteKey(self, root, value):
        i = 0
        while i < len(root.keys) and value > root.keys[i]:
            i += 1
        if root.leaf:
            if i < len(root.keys) and value == root.keys[i]:
                root.keys.pop(i)
            return
        if i < len(root.children):
            if i < len(root.keys) and value == root.keys[i]:
                return self.deleteInternalNode(root, value, i)
            elif len(root.children[i].keys) >= self.t:
                return self.deleteKey(root.children[i], value)
            else:
                if i != 0 and i + 2 < len(root.children):
                    if len(root.children[i - 1].keys) >= self.t:
                        self.deleteSibling(root, i, i - 1)
                    elif len(root.children[i + 1].keys) >= self.t:
                        self.deleteSibling(root, i, i + 1)
                    else:
                        self.deleteMerge(root, i, i + 1)
                elif i == 0:
                    if len(root.children[i + 1].keys) >= self.t:
                        self.deleteSibling(root, i, i + 1)
                    else:
                        self.deleteMerge(root, i, i + 1)
                elif i + 1 == len(root.children):
                    if len(root.children[i - 1].keys) >= self.t:
                        self.deleteSibling(root, i, i - 1)
                    else:
                        self.deleteMerge(root, i, i - 1)
                return self.deleteKey(root.children[min(i, len(root.children) - 1)], value)

    def deleteInternalNode(self, root, value, i):
        if root.leaf:
            if root.keys[i] == value:
                root.keys.pop(i)
                return
            return
        if len(root.children[i].keys) >= self.t:
            root.keys[i] = self.deletePredecessor(root.children[i])
            return
        elif len(root.children[i + 1].keys) >= self.t:
            root.keys[i] = self.deleteSuccessor(root.children[i + 1])
            return
        else:
            self.deleteMerge(root, i, i + 1)
            self.deleteInternalNode(root.children[i], value, self.t - 1)
    
    def deletePredecessor(self, root):
        if root.leaf:
            return root.keys.pop()
        n = len(root.keys) - 1
        if len(root.children[n].keys) >= self.t:
            self.deleteSibling(root, n + 1, n)
        else:
            self.deleteMerge(root, n, n + 1)
        return self.deletePredecessor(root.children[n])

    def deleteSuccessor(self, root):
        if root.leaf:
            return root.keys.pop(0)
        if len(root.children[0].keys) >= self.t:
            self.deleteSibling(root, 0, 1)
        else:
            self.deleteMerge(root, 0, 1)
        return self.deleteSuccessor(root.children[0])

    def deleteSibling(self, root, i, j):
        currNode = root.children[i]
        if i < j:
            rightSideNode = root.children[j]
            currNode.keys.append(root.keys[i])
            root.keys[i] = rightSideNode.keys.pop(0)
            if not rightSideNode.leaf:
                currNode.children.append(rightSideNode.children.pop(0))
        else:
            leftSideNode = root.children[j]
            currNode.keys.insert(0, root.keys[i - 1])
            root.keys[i - 1] = leftSideNode.keys.pop()
            if not leftSideNode.leaf:
                currNode.children.insert(0, leftSideNode.children.pop())

    def deleteMerge(self, root, i, j):
        if i < j:
            leftNode = root.children[i]
            rightNode = root.children[j]
            leftNode.keys.append(root.keys[i])
            leftNode.keys.extend(rightNode.keys)
            if not rightNode.leaf:
                leftNode.children.extend(rightNode.children)
            root.keys.pop(i)
            root.children.pop(j)
            newNode = leftNode
        else:
            leftNode = root.children[j]
            rightNode = root.children[i]
            leftNode.keys.append(root.keys[j])
            leftNode.keys.extend(rightNode.keys)
            if not rightNode.leaf:
                leftNode.children.extend(rightNode.children)
            root.keys.pop(j)
            root.children.pop(i)
            newNode = leftNode
        if root == self.root and len(root.keys) == 0:
            self.root = newNode

    def searchKey(self, root, value):
        i = 0
        while i < len(root.keys) and value > root.keys[i]:
            i += 1
        if i < len(root.keys) and value == root.keys[i]:
            return root.keys[i]
        elif root.leaf:
            return "Data not Found"
        self.searchKey(root.children[i], value)

    def printTree(self, root, level):
        if len(root.keys) == 0:
            return
        print(f"\nLevel {level} - {len(root.keys)}:")
        for i in root.keys:
            print(i, end = " ")
        level += 1
        if len(root.children) > 0:
            for i in root.children:
                self.printTree(i, level)
    
    def search(self, value):
        return self.searchKey(self.root, value)
    
    def traverse(self):
        self.printTree(self.root, 0)

    def delete(self, value):
        self.deleteKey(self.root, value)

t = int(input("T: "))
bTree = BTree(t)
while True:
    print("\n0. Exit\n1. Insert\n2. Delete\n3. Search\n4. Traversals")
    option = int(input("\nOption: "))
    if option == 0:
        break
    match option:
        case 1:
            value = int(input("Value: "))
            bTree.insert(value)
        case 2:
            value = int(input("Value: "))
            bTree.delete(value)
        case 3:
            value = int(input("Value: "))
            result = bTree.search(value)
            print(result if result != -1 else "Not found")
        case 4:
            bTree.traverse()