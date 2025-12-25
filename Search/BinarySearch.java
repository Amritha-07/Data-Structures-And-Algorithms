import java.util.Scanner;

public class BinarySearch {
    static int binarySearch(int[] arr, int data, int start, int end) {
        if(end < start) return -1;
        int middle = start + (end-start) / 2;
        if(data == arr[middle]) return middle;
        if (data < arr[middle]) return binarySearch(arr, data, start, middle - 1);
        else return binarySearch(arr, data, middle + 1, end);
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
        System.out.print("Data: ");
        int data = sc.nextInt();
        int index = binarySearch(arr, data, 0, n - 1);
        if (index != -1) System.out.println("Data: " + arr[index] + "\nIndex: " + index);
        else System.out.println("Data not Found");
    }
}
