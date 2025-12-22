import java.util.Scanner;

public class MergeSort {
    static void merge(int[] arr, int[] left, int[] right, int l, int r) {
        int k = 0, i = 0, j = 0;
        while (i < l && j < r) {
            if (left[i] < right[j]) {
                arr[k] = left[i];
                i++;
            }
            else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < l) {
            arr[k] = left[i];
            k++;
            i++;
        }
        while (j < r) {
            arr[k] = right[j];
            k++;
            j++;
        }
    }

    static void mergeSort(int[] arr, int n) {
        if (n < 2) return;
        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];
        for(int i = 0; i < mid; i++) left[i] = arr[i];
        for(int i = 0; i < n - mid; i++) right[i] = arr[mid + i];
        mergeSort(left, mid);
        mergeSort(right, n - mid);
        merge(arr, left, right, mid, n - mid);
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
        mergeSort(arr, n);
        System.out.println("Sorted Array: ");
        for(int i = 0; i < n; i++) {
            System.out.println(arr[i] + " ");
        }
    }
}
