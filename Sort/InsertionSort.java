import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Array: ");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for(int i = 0; i < n ; i++) {
            int value = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > value) {
                arr[j+1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = value; 
        }
        System.out.println("Sorted Array: ");
        for(int i = 0; i < n; i++) {
            System.out.println(arr[i] + " ");
        }
    }
}