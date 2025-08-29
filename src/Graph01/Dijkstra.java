package Graph01;

import java.util.*;

public class Dijkstra {
    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        
        int src = 0;
        dijkstra(graph, src);
    }

    static void dijkstra(ArrayList<Edge>[] graph, int src) {
        int[] dist = new int[graph.length];  // dist[i] -> src to i
        for (int i = 0; i < graph.length; i++) {
            if(i != src) {
                dist[i] = Integer.MAX_VALUE; // +infinity
            }
        }

        boolean[] vis = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while(!pq.isEmpty()) {
            Pair curr = pq.remove();
            if(!vis[curr.n]) {
                vis[curr.n] = true;
                //neighbors 
                // for each
                // for (Edge e : graph[curr.n]) {
                //     int u = e.src;
                //     int v = e.dest;
                //     int wt = e.wt;

                //     if (dist[u] + wt < dist[v]) { // update distance of source to v
                //         dist[v] = dist[u] + wt;
                //         pq.add(new Pair(v, dist[v]));
                //     }
                // }
                for (int i = 0; i < graph[curr.n].size(); i++) {
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if(dist[u] + wt < dist[v]) { // update distance of srource to v
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
        // print all sources to vertices shortest dist
        for (int i = 0; i < dist.length; i++) {
            System.out.println(dist[i] + " ");
        }
        System.out.println();
    }

    static class Pair implements Comparable<Pair> {
        int n; int path;

        Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path; // path beased soring for my pairs
        }
    }

    static class Edge {
        int src, dest, wt;

        Edge(int s, int d, int w) {
            src = s; dest = d; wt = w;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>(); 
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }
}
