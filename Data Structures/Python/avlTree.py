class Node:
	def __init__(self, value):
		self.value = value
		self.left = None
		self.right = None
		self.height = 1

class AVLTree:
	def __init__(self):
		self.root = None

	def height(self, node):
		if node == None:
			return 0
		return node.height

	def balance(self, node):
		if node == None:
			return 0
		return self.height(node.left) - self.height(node.right)

	def minValueNode(self, root):
		curr = root
		while curr.left != None:
			curr = curr.left
		return curr

	def insertNode(self, root, value):
		if root == None:
			return Node(value)
		elif value < root.value:
			root.left = self.insertNode(root.left, value)
		else:
			root.right = self.insertNode(root.right, value)
		root.height = 1 + max(self.height(root.left), self.height(root.right))
		balance = self.balance(root)
		if balance > 1 and value < root.left.value:
			return self.rightRotate(root)
		if balance < -1 and value > root.right.value:
			return self.leftRotate(root)
		if balance > 1 and value > root.left.value:
			root.left = self.leftRotate(root.left)
			return self.rightRotate(root)
		if balance < -1 and value < root.right.value:
			root.right = self.rightRotate(root.right)
			return self.leftRotate(root)
		return root

	def deleteNode(self, root, value):
		if root == None:
			return root
		elif value < root.value:
			root.left = self.deleteNode(root.left, value)
		elif value > root.value:
			root.right = self.deleteNode(root.right, value)
		else:
			if root.left == None:
				temp = root.right
				root = None
				return temp
			elif root.right == None:
				temp = root.left
				root = None
				return temp
		if root == None:
			return root
		root.height = 1 + max(self.height(root.left), self.height(root.right))
		balance = self.balance(root)
		if balance > 1 and value < root.left.value:
			return self.rightRotate(root)
		if balance < -1 and value > root.right.value:
			return self.leftRotate(root)
		if balance > 1 and value > root.left.value:
			root.left = self.leftRotate(root.left)
			return self.rightRotate(root)
		if balance < -1 and value < root.right.value:
			root.right = self.rightRotate(root.right)
			return self.leftRotate(root)
		return root

	def searchNode(self, root, value):
		if root == None or root.value == value:
			return root
		if value <  root.value:
			return self.searchNode(root.left, value)
		if value > root.value:
			return self.searchNode(root.right, value)

	def preorderTraversal(self, root):
		print(root.value, end = " ")
		if root.left != None:
			self.preorderTraversal(root.left)
		if root.right != None:
			self.preorderTraversal(root.right)

	def inorderTraversal(self, root):
		if root.left != None:
			self.inorderTraversal(root.left)
		print(root.value, end = " ")
		if root.right != None:
			self.inorderTraversal(root.right)

	def postorderTraversal(self, root):
		if root.left != None:
			self.postorderTraversal(root.left)
		if root.right != None:
			self.postorderTraversal(root.right)
		print(root.value, end = " ")

	def leftRotate(self, node):
		T1 = node.right
		T2 = T1.left
		T1.left = node
		node.right = T2
		node.height = 1 + max(self.height(node.left), self.height(node.right))
		T1.height = 1 + max(self.height(T1.left), self.height(T1.right))
		return T1

	def rightRotate(self, node):
		T1 = node.left
		T2 = T1.right
		T1.right = node
		node.left = T2
		node.height = 1 + max(self.height(node.left), self.height(node.right))
		T1.height = 1 + max(self.height(T1.left), self.height(T1.right))
		return T1

	def insert(self, value):
		self.root = self.insertNode(self.root, value)

	def delete(self, value):
		self.root = self.deleteNode(self.root, value)

	def search(self, value):
		value = self.searchNode(self.root, value)
		return -1 if value == None else value

	def traversal(self):
		if self.root == None:
			print("Tree is Empty")
		print("\nPreorder Traversal")
		self.preorderTraversal(self.root)
		print("\nInorder Traversal")
		self.inorderTraversal(self.root)
		print("\nPostorder Traversal")
		self.postorderTraversal(self.root)

avlTree = AVLTree()
while 1:
    print("\n0. Exit\n1. Insert\n2. Delete\n3. Search\n4. Traversal")
    option = int(input("\nOption: "))
    if option == 0:
        break
    match option:
        case 1:
            value = int(input("Value: "))
            avlTree.insert(value)
        case 2:
            value = int(input("Value: "))
            avlTree.delete(value)
        case 3:
            value = int(input("Value: "))
            print(avlTree.search(value))
        case 4:
            avlTree.traversal()