package Graph01;

import java.util.ArrayList;
import java.util.Arrays;

public class BellManFord {
    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        bellmanFord(graph, 0);
    }

    public static void bellmanFord(ArrayList<Edge>[] graph, int src) {
        int dist[] = new int[graph.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        int V = graph.length; // the loop will run from 0 to V -1

        // bellmanford
        for (int i = 0; i < V - 1; i++) {
            for (ArrayList<Edge> edges : graph) {
                for (Edge edge : edges) {
                    int u = edge.src;
                    int v = edge.dest;
                    int w = edge.wt;

                    if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                        dist[v] = dist[u] + w;
                    }
                }
            }
        }

        // Check for negative weight cycles
        // for (ArrayList<Edge> edges : graph) {
        //     for (Edge edge : edges) {
        //         int u = edge.src;
        //         int v = edge.dest;
        //         int w = edge.wt;

        //         if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
        //             System.out.println("Graph contains a negative weight cycle");
        //             return;
        //         }
        //     }
        // }

        // print the shortest paths
        for (int path : dist) {
            System.out.print(path + " ");
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));
    }

    static class Edge {
        int src, dest, wt;

        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
}