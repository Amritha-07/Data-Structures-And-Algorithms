import java.util.Scanner;

class HeapData {
	private int[] heap;
	private int end;
	private int capacity;

	public HeapData(int capacity) {
		this.heap = new int[capacity];
		this.end = 0;
		this.capacity = capacity;
	}

	public String insert(int value) {
		if (this.end == this.capacity) return "Heap is Full";
		heap[this.end] = value;
		int index = this.end;
		this.end += 1;
		while(index > 0 && heap[(int) Math.floor((index - 1) / 2)] < value) {
			int temp = heap[(int) Math.floor((index - 1) / 2)];
			heap[(int) Math.floor((index - 1) / 2)] = value;
			heap[index] = temp;
			index = (int) Math.floor((index - 1) / 2);
		}
		return "Inserted";
	}

	public String delete(int value) {
		int index = -1;
		for(int i = 0; i < this.end; i++) {
			if(heap[i] == value) {
				index = i;
				break;
			}
		}
		if (index == -1) return "Data not found";
		heap[index] = heap[this.end - 1];
		this.end -= 1;
		int largest;
		while(true) {
			int left = (index * 2) + 1;
			int right = (index * 2) + 2;
			largest = index;
			if(left < this.end && heap[left] > heap[largest]) largest = left;
			if(right < this.end && heap[right] > heap[largest]) largest = right;
			if(index != largest) {
				int temp = heap[largest];
				heap[largest] = heap[index];
				heap[index] = temp;
			} else break;
		}
		return "Deleted";
	}

	public void peek() {
		System.out.println(this.end == 0 ? "Heap is Empty" : heap[0]);
	}

	public void traverse() {
		for(int i=0; i<this.end; i++) {
			System.out.println(heap[i] + " ");
		}
	}

	public int getLength() {
		return this.end;
	}
}

class Heap {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Capacity: ");
		int capacity = sc.nextInt();
		HeapData heapData = new HeapData(capacity);
		int option;
		while (true) {
			System.out.print("\n0. Exit\n1. Insert\n2. Delete\n3. Peek\n4. Traverse\n5. Get Length\nOption: ");
			option = sc.nextInt();
			if (option == 0) return;
			switch (option) {
				case 1 -> {
					System.out.print("value: ");
					int value = sc.nextInt();
					System.out.println(heapData.insert(value));
				}
				case 2 -> {
					System.out.print("value: ");
					int value = sc.nextInt();
					System.out.println(heapData.delete(value));
				}
				case 3 -> {
					heapData.peek();
				}
				case 4 -> heapData.traverse();
				case 5 -> System.out.println(heapData.getLength());
				default -> System.out.println("Please Choose a valid option");
			}
		}
	}
}