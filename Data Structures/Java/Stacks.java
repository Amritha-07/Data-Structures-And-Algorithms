
import java.util.Scanner;

class StackData {
    private final int size;
    private final int[] stack;
    private int top;

    public StackData(int size) {
        this.size = size;
        this.stack = new int[size];
        this.top = -1;
    }

    public void push(int data) {
        if(isFull()) {
            System.out.println("Stack is Full");
        } else {
            stack[++top] = data;
        }
    }

    public int pop() {
        if(isEmpty()) {
            System.out.println("Stack is Empty");
        } else {
            return stack[top--];
        }
        return -1;
    }

    public int peek() {
        if(isEmpty()) {
            System.out.println("Stack is Empty");
        } else {
            return stack[top];
        }
        return -1;
    }

    public Boolean isFull() {
        return top == size - 1;
    }

    public Boolean isEmpty() {
        return top < 0;
    }

    public int size() {
        return top + 1;
    }
}

@SuppressWarnings("unused")
public class Stacks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Size: ");
        int size = sc.nextInt();
        StackData stackData = new StackData(size);
        int option;
        while (true) {
            System.out.print("\n0. Exit\n1. Push\n2. Pop\n3. Peek\n4. Is Empty\n5. Is Full\n6. Size\nOption: ");
            option = sc.nextInt();
            if (option == 0) break;
            switch (option) {
                case 1 -> {
                    System.out.print("Data: ");
                    int data = sc.nextInt();
                    stackData.push(data);
                }
                case 2 -> System.out.println(stackData.pop());
                case 3 -> System.out.println(stackData.peek());
                case 4 -> System.out.println(stackData.isEmpty());
                case 5 -> System.out.println(stackData.isFull());
                case 6 -> System.out.println(stackData.size());
                default -> System.out.println("Please Choose a valid option");
            }
        }
    }
    
}

