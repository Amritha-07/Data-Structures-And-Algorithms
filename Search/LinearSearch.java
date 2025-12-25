import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Array: ");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Data: ");
        int data = sc.nextInt();
        int flag = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] == data) {
                System.out.println("Data: " + arr[i] + "\nIndex: " + i);
                flag = 1;
                break;
            }
        }
        if(flag == 0) System.out.println("Data not Found");
    }   
}
