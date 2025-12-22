import java.util.Scanner;

public class QuickSort {
    static void quickSort(int arr[], int start, int end) {
        if (start >= end) return;
        int j = start-1;
        int k = start;
        while(k < end - 1) {
            if(arr[k] < arr[end-1]) {
                j += 1;
                int temp = arr[k];
                arr[k] = arr[j];
                arr[j] = temp;
            }
            k += 1;
        }
        int temp = arr[end-1];
        arr[end-1] = arr[j+1];
        arr[j+1] = temp;
        quickSort(arr, start, j+1);
        quickSort(arr, j+2, end);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Array: ");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        quickSort(arr, 0, n);
        System.out.println("Sorted Array: ");
        for(int i = 0; i < n; i++) {
            System.out.println(arr[i] + " ");
        }
    }
}