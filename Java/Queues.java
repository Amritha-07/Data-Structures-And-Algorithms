
import java.util.Scanner;

class QueueData {
    private final int size;
    private final int[] queue;
    private int end;

    public QueueData(int size) {
        this.size = size;
        this.queue = new int[size];
        this.end = -1;
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is Full");
        } else {
            queue[++end] = data;
        }
    }

    public int dequeue() {
        int first = -1;
        if (isEmpty()) {
            System.out.println("Queue is Empty");
        } else {
            first = queue[0];
            for(int i = 0; i < end; i++) {
                queue[i] = queue[i+1];
            }
            end--;
        }
        return first;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
        } else {
            return queue[0];
        }
        return -1;
    }

    public boolean isFull() {
        return end == size - 1;
    }

    public boolean isEmpty() {
        return end < 0;
    }

    public int size() {
        return end + 1;
    }
}

@SuppressWarnings("unused")
public class Queues {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Size: ");
        int size = sc.nextInt();
        QueueData queueData = new QueueData(size);
        int option;
        while (true) { 
            System.out.print("\n0. Exit\n1. Enqueue\n2. Dequeue\n3. Peek\n4. Is Empty\n5. Is Full\n6. Size\nOption: ");
            option = sc.nextInt();
            if (option == 0) break;
            switch (option) {
                case 1 -> {
                    System.out.print("Data: ");
                    int data = sc.nextInt();
                    queueData.enqueue(data);
                }
                case 2 -> System.out.println(queueData.dequeue());
                case 3 -> System.out.println(queueData.peek());
                case 4 -> System.out.println(queueData.isEmpty());
                case 5 -> System.out.println(queueData.isFull());
                case 6 -> System.out.println(queueData.size());
                default -> System.out.println("Please Choose a valid option");
            }
        }
    }
}