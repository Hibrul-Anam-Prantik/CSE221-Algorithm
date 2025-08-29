package Graph01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_DFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        int n = 10; // number of nodes
        // adding nodes to the graph -> initialization
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        // adding edges to the graph
        graph.get(4).add(7);
        graph.get(5).add(8);
        graph.get(6).add(9);
        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(3);
        graph.get(1).add(4);
        graph.get(2).add(4);
        graph.get(2).add(5);
        graph.get(3).add(6);
        graph.get(4).add(6);
        // Perform BFS and DFS
        System.out.println("Performing BFS:\n===============");
        BFS(graph, 0);
        System.out.println("Performing DFS:\n===============");
        boolean[] visited = new boolean[graph.size()];  // visited array for DFS traversal
        DFS(graph, 0, visited);
        System.out.println("===============");
        System.out.println("===============");

    }

    static void BFS(ArrayList<ArrayList<Integer>> graph, int start) {
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();
            System.out.println("Visiting: " + curr);

            for (int neighbor : graph.get(curr)) {
                if (!visited[neighbor]) {
                    q.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
        System.out.println("===============");
        System.out.println("===============");
    }

    static void DFS(ArrayList<ArrayList<Integer>> graph, int curr, boolean[] vis) {
        vis[curr] = true;
        System.out.println("Visiting: "+ curr);

        for (int neighbor : graph.get(curr)) {
            if (!vis[neighbor]) DFS(graph, neighbor, vis);
        }
    }
}