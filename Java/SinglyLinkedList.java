
import java.util.Scanner;

class SNode {
    public int data;
    public SNode next;

    SNode(int data) {
        this.data = data;
        this.next = null;
    } 
}

class SinglyLinkedListData {
    public SNode head = null;

    public String insertAtBeginning(int element) {
        SNode newNode = new SNode(element);
        newNode.next = head;
        head = newNode;
        return "Inserted";
    }

    public  String deleteAtBeginning() {
        if (head == null) return "Linked List is Empty";
        head = head.next;
        return "Deleted";
    }

    public String insertAtEnding(int element) {
        SNode newNode = new SNode(element);
        if (head == null) {
            head = newNode;
            return "Inserted";
        }
        SNode curr = head;
        while (curr.next != null) curr = curr.next;
        curr.next = newNode;
        return "Inserted";
    }

    public String deleteAtEnding() {
        if (head == null) return "Linked List is Empty";
        if (head.next == null) {
            head = null;
            return "Deleted";
        }
        SNode curr = head;
        while (curr.next.next != null) curr = curr.next;
        curr.next = null;
        return "Deleted";
    }

    public String insertAfterData(int element, int data) {
        if (head == null) return "Linked List is Empty";
        SNode curr = head;
        SNode newNode = new SNode(element);
        while (curr != null) {
            if (curr.data == data) {
                newNode.next = curr.next;
                curr.next = newNode;
                return "Inserted";
            }
            curr = curr.next;
        }
        return "Data not Found";
    }

    public String deleteAfterData(int data) {
        if (head == null) return "Linked List is Empty";
        SNode curr = head;
        while (curr != null) {
            if(curr.next == null) return "No element after this data";
            if(curr.data == data) {
                curr.next = curr.next.next;
                return "Deleted";
            }
            curr = curr.next;
        }
        return "Data not Found";
    }

    public String insertBeforeData(int element, int data) {
        if (head == null) return "Linked List is Empty";
        SNode newNode = new SNode(element);
        if (head.data == data) {
            newNode.next = head;
            head = newNode;
            return "Inserted";
        }
        SNode curr = head;
        while(curr.next != null) {
            if (curr.next.data  == data) {
                newNode.next = curr.next;
                curr.next = newNode;
                return "Inserted";
            }
            curr = curr.next;
        }
        return "Data not Found";
    }

    public String deleteBeforeData(int data) {
        if (head == null) return "Linked List is Empty";
        if (head.data == data) return "No element before this data";
        SNode prev = null;
        SNode curr = head;
        while (curr.next != null) {
            if(curr.next.data == data) {
                if (prev == null) {
                    head = curr.next;
                    return "Deleted";
                }
                prev.next = curr.next;
                return "Deleted";
            }
            prev = curr;
            curr = curr.next;
        }
        return "Data not Found";
    }

    public String deleteData(int data) {
        if (head == null) return "Linked List is Empty";
        if (head.data == data) {
            head = head.next;
            return "Deleted";
        }
        SNode curr = head;
        while (curr.next != null) {
            if (curr.next.data == data) {
                curr.next = curr.next.next;
                return "Deleted";
            }
            curr = curr.next;
        } 
        return "Data not Found";
    }

    public void traverse() {
        System.out.print("Traverse: ");
        if (head == null) System.out.println("Linked List is Empty");
        SNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    public Boolean isEmpty() {
        return head == null;
    }

    public int getLength() {
        int length = 0;
        SNode curr = head;
        while (curr != null) {
            length += 1;
            curr = curr.next;
        }
        return length;
    }

    public int search(int data) {
        if (head == null) System.out.println("Linked List is Empty");   
        SNode curr = head;
        while (curr != null) {
            if (curr.data == data) {
                return data;
            }
            curr = curr.next;
        }
        return -1;
    }

    public String reverse() {
        if (head == null) return "Linked List is Empty";   
        if (head.next == null) return "Reversed";
        SNode prev = null;
        SNode curr = head;
        SNode nex;
        while (curr != null) {
            nex = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nex;
        }
        head = prev;
        return "Reversed";
    }
}

public class SinglyLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinglyLinkedListData singlyLinkedList = new SinglyLinkedListData();
        int option;
        while (true) { 
            System.out.print("\n0. Exit\n1. Insert at Beginning\n2. Delete at Beginning\n3. Insert at Ending\n4. Delete at Ending\n5. Insert after Data\n6. Delete after Data\n7. Insert before Data\n8. Delete before Data\n9. Delete Data\n10. Traverse\n11. Is Empty\n12. Length\n13. Search\n14. Reverse\nOption: ");
            option = sc.nextInt();
            if (option == 0) return;
            switch (option) {
                case 1 -> {
                    System.out.print("Element: ");
                    int element = sc.nextInt();
                    System.out.println(singlyLinkedList.insertAtBeginning(element));
                }
                case 2 -> System.out.println(singlyLinkedList.deleteAtBeginning());
                case 3 -> {
                    System.out.print("Element: ");
                    int element = sc.nextInt();
                    System.out.println(singlyLinkedList.insertAtEnding(element));
                }
                case 4 -> System.out.println(singlyLinkedList.deleteAtEnding());
                case 5 -> {
                    System.out.print("Element: ");
                    int element = sc.nextInt();
                    System.out.print("Data: ");
                    int data = sc.nextInt();
                    System.out.println(singlyLinkedList.insertAfterData(element, data));
                }
                case 6 -> {
                    System.out.print("Data: ");
                    int data = sc.nextInt();
                    System.out.println(singlyLinkedList.deleteAfterData(data));
                }
                case 7 -> {
                    System.out.print("Element: ");
                    int element = sc.nextInt();
                    System.out.print("Data: ");
                    int data = sc.nextInt();
                    System.out.println(singlyLinkedList.insertBeforeData(element, data));
                }
                case 8 -> {
                    System.out.print("Data: ");
                    int data = sc.nextInt();
                    System.out.println(singlyLinkedList.deleteBeforeData(data));
                }
                case 9 -> {
                    System.out.print("Data: ");
                    int data = sc.nextInt();
                    System.out.println(singlyLinkedList.deleteData(data));
                }
                case 10 -> singlyLinkedList.traverse();
                case 11 -> System.out.println(singlyLinkedList.isEmpty());
                case 12 -> System.out.println(singlyLinkedList.getLength());
                case 13 -> {
                    System.out.print("Data: ");
                    int data = sc.nextInt();
                    System.out.println(singlyLinkedList.search(data));
                }
                case 14 -> System.out.println(singlyLinkedList.reverse());
                default -> System.out.println("Please Choose a valid option");
            }
        }
    }
}