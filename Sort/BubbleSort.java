import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Array: ");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        while(true) {
            Boolean swapped = false;
            for(int i = 0; i < n - 1; i++) {
                if(arr[i] > arr[i+1]) {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false) break;
        }
        System.out.println("Swapped Array: ");
        for(int i = 0; i < n; i++) {
            System.out.println(arr[i] + " ");
        }
    }
}
