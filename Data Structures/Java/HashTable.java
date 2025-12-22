
import java.util.Scanner;

class HNode {
    public int data;
    public HNode next;

    public HNode(int data) {
        this.data = data;
        next = null;
    }
}

class HashTableData {
    private int capacity;
    private HNode[] hashTable;

    public HashTableData(int capacity) {
        this.capacity = capacity;
        this.hashTable = new HNode[capacity];
    }

    private int hash(int value) {
        return value % this.capacity;
    }

    public String insert(int value) {
        int index = hash(value);
        HNode newNode = new HNode(value);
        if (hashTable[index] == null) {
            hashTable[index] = newNode;
            return "Inserted";
        }
        HNode curr = hashTable[index];
        while (curr.next != null) curr = curr.next;
        curr.next = newNode;
        return "Inserted";
    }

    public String delete(int value) {
        int index = hash(value);
        HNode curr = hashTable[index];
        if (curr.data == value) {
            hashTable[index] = curr.next;
            return "Deleted";
        }
        while (curr.next != null) {
            if (curr.next.data == value) {
                curr.next = curr.next.next;
                return "Deleted";
            }
            curr = curr.next;
        }
        return "Data not Found";
    }

    public int search(int value) {
        int index = hash(value);
        HNode curr = hashTable[index];
        while (curr != null) {
            if (curr.data == value) return curr.data;
        }
        return -1;
    }

    public void traverse() {
        for(int i = 0; i < capacity; i++) {
            HNode curr = hashTable[i];
            if (curr == null) {
                System.out.println("NULL");
                continue;
            }
            while (curr != null) {
                System.out.print(curr.data + " ");
                curr = curr.next;
            }
            System.out.println("");
        }
    }
}

class HashTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Capacity: ");
        int capacity = sc.nextInt();
        HashTableData hashTableData = new HashTableData(capacity);
        int option;
        while (true) { 
            System.out.print("\n0. Exit\n1. Insert\n2. Delete\n3. Search\n4. Traverse\nOption: ");
            option = sc.nextInt();
            if (option == 0) return;
            switch (option) {
                case 1 -> {
                    System.out.print("value: ");
                    int value = sc.nextInt();
                    System.out.println(hashTableData.insert(value));
                }
                case 2 -> {
                    System.out.print("value: ");
                    int value = sc.nextInt();
                    System.out.println(hashTableData.delete(value));
                }
                case 3 -> {
                    System.out.print("value: ");
                    int value = sc.nextInt();
                    System.out.println(hashTableData.search(value));
                }
                case 4 -> hashTableData.traverse();
                default -> System.out.println("Please Choose a valid option");
            }
        }
    }
}