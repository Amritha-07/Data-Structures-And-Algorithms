import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

class BellmanFord {
	static int[] bellmanFord(ArrayList<Integer[]> graph, int size, int start) {
		int[] dist = new int[size];
		Arrays.fill(dist, (int)1e8); 
		dist[start] = 0;

		for(int i = 0; i < size; i++) {
			for(Integer[] edge: graph) {
				if(dist[edge[0]] != (int)1e8 && dist[edge[0]] + edge[2] < dist[edge[1]]) {
					if(i == size - 1) return new int[] {-1};
					dist[edge[1]] = dist[edge[0]] + edge[2];
				}
			}
		}
		return dist;
	}

	public static void main(String[] args) {
		ArrayList<Integer[]> graph = new ArrayList<Integer[]>();
        Scanner sc = new Scanner(System.in);
		System.out.print("Size: ");
		int size = sc.nextInt();
		System.out.println();
        while (true) {
            System.out.print("0. Exit\n1.Add Edge\nOption: ");
            int option = sc.nextInt();
            if (option == 0) break;
            switch (option) {
                case 1 -> {
                    System.out.print("Node A: ");
                    int nodeA = sc.nextInt();
                    System.out.print("Node B: ");
                    int nodeB = sc.nextInt();
					System.out.print("Weight: ");
					int weight = sc.nextInt();
					if(nodeA >= 0 && nodeA < size && nodeB >= 0 && nodeB < size) graph.add(new Integer[]{nodeA, nodeB, weight});
					else System.out.println("Enter a valid node");
                }
                default -> {
                    System.out.println("Please Choose a valid option");
                }
            }
        }
		System.out.println("Start Node: ");
		int start = sc.nextInt();
		int[] dist = bellmanFord(graph, size, start);
		for(int i = 0; i < size; i++) {
			System.out.println("Node Start: " + 0 + "\nNode End: " + i + "\nDistance: " + dist[i]);
		}
	}
}