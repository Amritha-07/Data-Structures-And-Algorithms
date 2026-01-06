
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BreadthFirstSearch {
    static int bfs(HashMap<Integer, ArrayList<Integer>> graph, int data, boolean isSearch) {
        HashMap<Integer, Boolean> visited = new HashMap<>();
        Queue<Integer> traverse = new LinkedList<Integer>();

        for(int start: graph.keySet()) {
            if(visited.getOrDefault(start, false) == true) continue;

            traverse.add(start);
            visited.put(start, true);

            while(!traverse.isEmpty()) {
                Integer curr = traverse.poll();
                if (isSearch) {
                    if (curr == data) return curr;
                } else {
                    System.out.print(curr + " ");
                }
                ArrayList<Integer> neighbours = graph.get(curr);
                if (neighbours == null) continue;
                for(Integer node: neighbours) {
                    if(!visited.getOrDefault(node, false)) {
                        visited.put(node, true);
                        traverse.add(node);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        Scanner sc = new Scanner(System.in);
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
                    graph.putIfAbsent(nodeA, new ArrayList<>());
                    graph.get(nodeA).add(nodeB);
                }
                default -> {
                    System.out.println("Please Choose a valid option");
                }
            }
        }
        System.out.println("Edges: "); 
        for(int start: graph.keySet()) {
            ArrayList<Integer> neighbours = graph.get(start);
            if(neighbours == null) continue;
            for(Integer node : neighbours) {
                System.out.println(start + "---" + node);
            }
        }
        System.out.println("Traverse: ");
        bfs(graph, 0, false);
        System.out.println("\nSearch: ");
        System.out.print("Data: ");
        int data = sc.nextInt();
        int result = bfs(graph, data, true);
        System.out.println(result == -1 ? "Data not Found" : result);
    }
}