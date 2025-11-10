class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

class BinarySeachTree:
    def __init__(self):
        self.root = None

    def insert(self, value):
        newNode = Node(value)
        if self.root == None:
            self.root = newNode
        curr = self.root
        while curr != None:
            if value < curr.value and curr.left != None:
                curr = curr.left
            elif value > curr.value and curr.right != None:
                curr = curr.right
            else:
                break
        if value < curr.value:
            curr.left = newNode
        elif value > curr.value:
            curr.right = newNode
        return "Inserted"
    
    def getSuccessor(self, root):
        curr = root
        while curr != None and curr.left != None:
            curr = curr.left
        return curr
    
    def deleteNode(self, root, value):
        if root == None:
            print("Data not Found")
            return root
        if value < root.value:
            root.left = self.deleteNode(root.left, value)
        elif value > root.value:
            root.right = self.deleteNode(root.right, value)
        else:
            if root.left == None:
                return root.right
            if root.right == None:
                return root.left
            successor = self.getSuccessor(root.right)
            root.value = successor.value
            root.right = self.deleteNode(root.right, root.value)
        return root
    
    def delete(self, value):
        if self.root == None:
            print("Tree is Empty")
        else:
            self.root = self.deleteNode(self.root, value)
            print("Deleted")

    def searchNode(self, root, value):
        if root == None:
            return "Data not Found"
        if value < root.value:
            self.searchNode(root.left, value)
        elif value > root.value:
            self.searchNode(root.right, value)
        else:
            return root.value
    
    def search(self, value):
        if self.root == None:
            return "Tree is Empty"
        else:
            return self.searchNode(self.root, value)
        
    def preorderTraversal(self, root):
        print(root.value)
        if root.left != None:
            self.preorderTraversal(root.left)
        if root.right != None:
            self.preorderTraversal(root.right)
        
    def inorderTraversal(self, root):
        if root.left != None:
            self.inorderTraversal(root.left)
        print(root.value)
        if root.right != None:
            self.inorderTraversal(root.right)
    
    def postorderTraversal(self, root):
        if root.left != None:
            self.postorderTraversal(root.left)
        if root.right != None:
            self.postorderTraversal(root.right)
        print(root.value)

    def traversals(self):
        if self.root == None:
            print("Tree is Empty")
            return
        print("\nPreorder Traversal")
        self.preorderTraversal(self.root)
        print("\nInorder Traversal")
        self.inorderTraversal(self.root)
        print("\nPostorder Traversal")
        self.postorderTraversal(self.root)

binarySearchTree = BinarySeachTree()
while 1:
    print("\n0. Exit\n1. Insert\n2. Delete\n3. Search\n4. Traversals")
    option = int(input("\nOption: "))
    if option == 0:
        break
    match option:
        case 1:
            value = int(input("Value: "))
            print(binarySearchTree.insert(value))
        case 2:
            value = int(input("Value: "))
            binarySearchTree.delete(value)
        case 3:
            value = int(input("Value: "))
            print(binarySearchTree.search(value))
        case 4:
            binarySearchTree.traversals()