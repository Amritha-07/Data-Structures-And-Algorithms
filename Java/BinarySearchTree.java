import java.util.Scanner;

class Node {
	public int value;
	public Node left;
	public Node right;

	public Node(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}	
}

class BinarySearchTreeDate {
	public Node root;

	public BinarySearchTreeDate() {
		this.root = null;
	}

	public String insert(int value) {
		Node newNode = new Node(value);
		if(this.root == null) {
			this.root = newNode;
			return "Inserted";
		}
		Node curr = this.root;
		while(true) {
			if(value < curr.value && curr.left != null) curr = curr.left;
			else if(value > curr.value && curr.right != null) curr = curr.right;
			else break;
		}
		if(value <= curr.value) {
			curr.left = newNode;
		} else {
			curr.right = newNode;
		}
		return "Inserted";
	}

	public Node getSuccessor(Node curr) {
		while (curr != null && curr.left != null) {
			curr = curr.left;
		}
		return curr;
	}

	public Node deleteNode(Node root, int value) {
		if(root == null) {
			System.out.println("Data not Found");
			return root;
		}
		if(value < root.value) root.left = deleteNode(root.left, value);
		else if(value > root.value) root.right = deleteNode(root.right, value);
		else {
			if (root.left == null) return root.right;
			if (root.right == null) return root.left;
			else {
				Node successor = getSuccessor(root.right);
				root.value = successor.value;
				root.right = deleteNode(root.right, successor.value);
			}
		}
		return root;
	}

	public String delete(int value) {
		if(this.root == null) return "Tree is Empty";
		this.root = deleteNode(this.root, value);
		return "Deleted";
	}

	public int searchNode(Node root, int value) {
		if(root == null) return -1;
		if(value < root.value) return searchNode(root.left, value);
		else if(value > root.value) return searchNode(root.right, value);
		else return root.value;
	}

	public int search(int value) {
		if(this.root == null) {
			System.out.println("Tree is Empty");
			return -1;
		} else {
			return searchNode(this.root, value);
		}
	}

	public void preorderTraversal(Node root) {
		System.out.println(root.value + " ");
		if(root.left != null) preorderTraversal(root.left);
		if(root.right != null) preorderTraversal(root.right);
	}

	public void inorderTraversal(Node root) {
		if(root.left != null) inorderTraversal(root.left);
		System.out.println(root.value + " ");
		if(root.right != null) inorderTraversal(root.right);
	}

	public void postorderTraversal(Node root) {
		if(root.left != null) postorderTraversal(root.left);
		if(root.right != null) postorderTraversal(root.right);
		System.out.println(root.value + " ");
	}

	public void traverse() {
		if(this.root == null) System.out.println("Tree is Empty");
		System.out.println("\nPreorder Traversal");
		preorderTraversal(this.root);
		System.out.println("\nInorder Traversal");
		inorderTraversal(this.root);
		System.out.println("\nPostorder Traversal");
		postorderTraversal(this.root);
	}
}

class BinarySearchTree {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BinarySearchTreeDate binarySearchTreeDate = new BinarySearchTreeDate();
		int option;
		while (true) {
			System.out.print("\n0. Exit\n1. Insert\n2. Delete\n3. Search\n4. Traverse\nOption: ");
			option = sc.nextInt();
			if (option == 0) return;
			switch (option) {
				case 1 -> {
					System.out.print("value: ");
					int value = sc.nextInt();
					System.out.println(binarySearchTreeDate.insert(value));
				}
				case 2 -> {
					System.out.print("value: ");
					int value = sc.nextInt();
					System.out.println(binarySearchTreeDate.delete(value));
				}
				case 3 -> {
					System.out.print("value: ");
					int value = sc.nextInt();
					System.out.println(binarySearchTreeDate.search(value));
				}
				case 4 -> binarySearchTreeDate.traverse();
				default -> System.out.println("Please Choose a valid option");
			}
		}
	}
}