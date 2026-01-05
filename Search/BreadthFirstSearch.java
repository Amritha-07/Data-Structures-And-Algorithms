
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BreadthFirstSearch {
    static int bfs(HashMap<Integer, ArrayList<Integer>> graph, int n, int data) {
        boolean[] visited = new boolean[n];
        Queue<Integer> traverse = new LinkedList<Integer>();
        for(int start = 0; start < n; start++) {
            if(visited[start] == true) continue;
            traverse.add(start);
            visited[start] = true;
            while (!traverse.isEmpty()) {
                Integer curr = traverse.poll();
                if (curr == data) return curr;
                ArrayList<Integer> neighbours = graph.get(curr);
                if (neighbours == null) continue;
                for(Integer node : neighbours) {
                    if(visited[node] != true) {
                        traverse.add(node);
                        visited[node] = true;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Node Length: ");
        int n = sc.nextInt();
        System.out.println("Node: ");
        for(int i = 0; i < n; i++) System.out.print(i + " ");
        System.out.println("");
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
                    if (nodeA < 0 || nodeA >= n || nodeB < 0 || nodeB >= n) {
                        System.out.println("Node does not exist");
                        continue;
                    }
                    graph.putIfAbsent(nodeA, new ArrayList<>());
                    graph.get(nodeA).add(nodeB);
                }
                default -> {
                    System.out.println("Please Choose a valid option");
                }
            }
        }
        System.out.println("Edges: "); 
        for(int i = 0; i < n; i++) {
            ArrayList<Integer> neighbours = graph.get(i);
            if(neighbours == null) continue;
            for(Integer node : neighbours) {
                System.out.println(i + "---" + node);
            }
        }
        System.out.println("Search: ");
        System.out.print("Data: ");
        int data = sc.nextInt();
        int result = bfs(graph, n, data);
        System.out.println(result == -1 ? "Data not Found" : result);
    }
}