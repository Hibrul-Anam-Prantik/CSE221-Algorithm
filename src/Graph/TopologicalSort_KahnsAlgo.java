package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort_KahnsAlgo {
    public static void main(String[] args) {
        int v = 6;  // number of vertices -> size
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        topSort(graph);
    }
    // graph creation
    static void createGraph(ArrayList<Edge>[] graph) {   // array of ArrayList->containg Edges
        // initializing the adjacency list
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        // adding edges
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

    }
    // Topological Sort using Kahn's Algorithm
    static void topSort(ArrayList<Edge>[] graph) {
        int[] inDeg = new int[graph.length]; // array to store in-degrees
        calcInDegree(graph, inDeg);  // calculate in-degrees
        Queue<Integer> q = new LinkedList<>();  // queue for BFS
        // adding all vertices with in-degree 0 to the queue
        for (int i = 0; i < inDeg.length; i++) {
            if(inDeg[i] == 0) q.add(i);
        }
        // BFS
        while(!q.isEmpty()) {
            int curr = q.poll();
            System.out.print(curr + " ");  // topological sort print
            for(Edge e : graph[curr]) {
                inDeg[e.dest]--;
                if(inDeg[e.dest] == 0) q.add(e.dest);
            }
        }
        System.out.println();
    }

    private static void calcInDegree(ArrayList<Edge>[] graph, int[] inDeg) {
        for (int i = 0; i < graph.length; i++) {
            for (Edge e : graph[i]) {
                inDeg[e.dest]++;
            }
        }
    }

    // Edge class
    static class Edge {
        int src, dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

}