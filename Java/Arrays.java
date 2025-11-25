
import java.util.Scanner;

class Student {
	int rollNo;
	String name;

    public Student(int rollNo, String name) {
		this.rollNo = rollNo;
		this.name = name;
    }
}

@SuppressWarnings("unused")
public class Arrays {
	public static Integer sum(Integer[] arr) {
		Integer sum = 0;
            for (Integer arr1 : arr) {
                sum += arr1;
            }
		return sum;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer[] arr = new Integer[5];
		for(int i = 0; i < 5; i++) {
			System.out.print("Number: ");
			arr[i] = sc.nextInt();
		}
		for(int i = 0; i < 5; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		Integer sum = sum(arr);
		System.err.println("Sum: " + sum);
		Student[] studentArr = new Student[3];
		for(int i = 0; i < 3; i++) {
			System.out.print("Roll No: ");
			int rollNo = sc.nextInt();
			System.out.print("Name: ");
			String name = sc.next();
			studentArr[i] = new Student(rollNo, name);
		}
		for(int i = 0; i < 3; i++) {
			System.out.println("Roll No: " + studentArr[i].rollNo);
			System.out.println("Name: " + studentArr[i].name);
		}
	}
}