import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Array: ");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++) {
            int minimum = i;
            for(int j = i + 1; j < n; j++) {
                if(arr[j] < arr[minimum]) {
                    minimum = j;
                }
            }
            if(i != minimum) {
                int temp = arr[i];
                arr[i] = arr[minimum];
                arr[minimum] = temp;
            }
        }
        System.out.println("Sorted Array: ");
        for(int i = 0; i < n; i++) {
            System.out.println(arr[i] + " ");
        }
    }
}