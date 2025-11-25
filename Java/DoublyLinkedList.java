import java.util.Scanner;

class Node {
    public int data;
    public Node previous;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.previous = null;
        this.next = null;
    }
}

class DoublyLinkedListData {
    public Node head = null;
    public Node tail = null;

    public String insertAtBeginning(int element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            return "Inserted";
        }
        newNode.next = head;
        head.previous = newNode;
        head = newNode;
        return "Inserted";
    }

    public String deleteAtBeginning() {
        if (isEmpty()) return "Linked List is Empty";
        if (head.next == null) {
            head = null;
            tail = null;
            return "Deleted";
        }
        head = head.next;
        head.previous = null;
        return "Deleted";
    }

    public String insertAtEnding(int element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            return "Inserted";
        }
        tail.next = newNode;
        newNode.previous = tail;
        tail = newNode;
        return "Inserted";
    }

    public String deleteAtEnding() {
        if (isEmpty()) return "Linked List is Empty";
        if (head.next == null) {
            head = null;
            tail = null;
            return "Deleted";
        }
        tail = tail.previous;
        tail.next = null;
        return "Deleted";
    }

    public String insertAfterData(int element, int data) {
        if (isEmpty()) return "Linked List is Empty";
        Node newNode = new Node(element);
        Node curr = head;
        while (curr != null) {
            if (curr.data == data) {
                newNode.previous = curr;
                newNode.next = curr.next;
                if (curr.next != null) curr.next.previous = newNode;
                else tail = newNode;
                curr.next = newNode;
                return "Inserted";
            }
            curr = curr.next;
        }
        return "Data not Found";
    }

    public String deleteAfterData(int data) {
        if (isEmpty()) return "Linked List is Empty";
        Node curr = head;
        while (curr.next != null) {
            if (curr.data == data) {
                curr.next = curr.next.next;
                if (curr.next != null) curr.next.previous = curr;
                else tail = curr;
                return "Deleted";
            }
            curr = curr.next;
        }
        if (curr.data == data) return "No element after this data";
        return "Data not Found";
    }

    public String insertBeforeData(int element, int data) {
        if (isEmpty()) return "Linked List is Empty";
        Node newNode = new Node(element);
        Node curr = head;
        while (curr != null) {
            if (curr.data == data) {
                newNode.next = curr;
                newNode.previous = curr.previous;
                if (curr.previous != null) curr.previous.next = newNode;
                else head = newNode;
                curr.previous = newNode;
                return "Inserted";
            }
            curr = curr.next;
        }
        return "Data not Found";
    }

    public String deleteBeforeData(int data) {
        if (isEmpty()) return "Linked List is Empty";
        if (head.data == data) return "No element before this data";
        Node curr = head;
        while (curr != null) {
            if (curr.data == data) {
                curr.previous = curr.previous.previous;
                if (curr.previous != null) curr.previous.next = curr;
                else head = curr;
                return "Deleted";
            }
            curr = curr.next;
        }
        return "Data not Found";
    }

    public String deleteData(int data) {
        if (isEmpty()) return "Linked List is Empty";
        Node curr = head;
        while (curr != null) {
            if (curr.data == data) {
                if (curr.previous != null) curr.previous.next = curr.next;
                else head = curr.next;
                if (curr.next != null) curr.next.previous = curr.previous;
                else tail = curr.previous;
                curr.next = null;
                curr.previous = null;
                return "Deleted";
            }
            curr = curr.next;
        }
        return "Data not Found";
    }

    public void traverse() {
        if (isEmpty()) {
            System.out.println("Linked List is Empty");
            return;
        }
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public void reverseTraverse() {
        if (isEmpty()) {
            System.out.println("Linked List is Empty");
            return;
        }
        Node curr = tail;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.previous;
        }
        System.out.println();
    }

    public Boolean isEmpty() {
        return head == null;
    }

    public int getLength() {
        int length = 0;
        Node curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        return length;
    }

    public int search(int data) {
        if (isEmpty()) {
            System.out.println("Linked List is Empty");
            return -1;
        }
        Node curr = head;
        while (curr != null) {
            if (curr.data == data) return data;
            curr = curr.next;
        }
        return -1;
    }

    public String reverse() { 
        if (head == null) return "Linked List is Empty"; 
        if (head.next == null) return "Reversed"; 
        Node curr = head; 
        while (curr != null) { 
            Node next = curr.next; 
            curr.next = curr.previous; 
            curr.previous = next; 
            curr = next; 
        } 
        Node temp = head;
        head = tail;
        tail = temp;
        return "Reversed"; 
    }
}

class DoublyLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoublyLinkedListData list = new DoublyLinkedListData();
        int option;
        while (true) {
            System.out.print("\n0. Exit\n1. Insert at Beginning\n2. Delete at Beginning\n3. Insert at Ending\n4. Delete at Ending\n5. Insert after Data\n6. Delete after Data\n7. Insert before Data\n8. Delete before Data\n9. Delete Data\n10. Traverse\n11. Reverse Traverse\n12. Is Empty\n13. Length\n14. Search\n15. Reverse\nOption: ");
            option = sc.nextInt();
            if (option == 0) return;

            switch (option) {
                case 1 -> {
                    System.out.print("Element: ");
                    int element = sc.nextInt();
                    System.out.println(list.insertAtBeginning(element));
                }
                case 2 -> System.out.println(list.deleteAtBeginning());
                case 3 -> {
                    System.out.print("Element: ");
                    int element = sc.nextInt();
                    System.out.println(list.insertAtEnding(element));
                }
                case 4 -> System.out.println(list.deleteAtEnding());
                case 5 -> {
                    System.out.print("Element: ");
                    int element = sc.nextInt();
                    System.out.print("Data: ");
                    int data = sc.nextInt();
                    System.out.println(list.insertAfterData(element, data));
                }
                case 6 -> {
                    System.out.print("Data: ");
                    int data = sc.nextInt();
                    System.out.println(list.deleteAfterData(data));
                }
                case 7 -> {
                    System.out.print("Element: ");
                    int element = sc.nextInt();
                    System.out.print("Data: ");
                    int data = sc.nextInt();
                    System.out.println(list.insertBeforeData(element, data));
                }
                case 8 -> {
                    System.out.print("Data: ");
                    int data = sc.nextInt();
                    System.out.println(list.deleteBeforeData(data));
                }
                case 9 -> {
                    System.out.print("Data: ");
                    int data = sc.nextInt();
                    System.out.println(list.deleteData(data));
                }
                case 10 -> list.traverse();
                case 11 -> list.reverseTraverse();
                case 12 -> System.out.println(list.isEmpty());
                case 13 -> System.out.println(list.getLength());
                case 14 -> {
                    System.out.print("Data: ");
                    int data = sc.nextInt();
                    System.out.println(list.search(data));
                }
                case 15 -> System.out.println(list.reverse());
                default -> System.out.println("Please Choose a valid option");
            }
        }
    }
}
