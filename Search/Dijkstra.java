import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Arrays;

public class Dijkstra {
    static int[] dijkstra(ArrayList<ArrayList<int[]>> adjList, int src, int size) {
        int[] dist = new int[size];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Arrays.fill(dist, (int) 1e8);
        dist[src] = 0;
        pq.offer(new int[] {0, src});
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int d = top[0];
            int u = top[1];

            if(d > dist[u]) continue;

            for(int[] p: adjList.get(u)) {
                int v = p[1];
                int w = p[0];
                
                if(dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new int[] {dist[u] + w, v});
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
		System.out.print("Size: ");
		int size = sc.nextInt();
        for(int i = 0; i < size; i++) {
            adjList.add(new ArrayList<>());
        }
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
					if(nodeA >= 0 && nodeA < size && nodeB >= 0 && nodeB < size) {
                        adjList.get(nodeA).add(new int[] {nodeB, weight});
                        adjList.get(nodeB).add(new int[] {nodeA, weight});
                    } 
                }
                default -> {
                    System.out.println("Please Choose a valid option");
                }
            }
        }
        int[] result = dijkstra(adjList, 0, size);
    
        for(int i = 0; i < size; i++) {
            System.out.println("Node: " + i + " Distance: " + result[i]);
        }
    }
}
