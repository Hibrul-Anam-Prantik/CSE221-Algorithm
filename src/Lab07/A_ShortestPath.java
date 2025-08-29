package Lab07;

import java.util.*;
import java.io.*;

public class A_ShortestPath {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        String[] l1 = br.readLine().trim().split("\\s+");
        int N = Integer.parseInt(l1[0]);
        int M = Integer.parseInt(l1[1]);
        int S = Integer.parseInt(l1[2]);
        int D = Integer.parseInt(l1[3]);

        int[] U = new int[M], V = new int[M], W = new int[M];

        String[] l2 = br.readLine().trim().split("\\s+"), l3 = br.readLine().trim().split("\\s+"), l4 = br.readLine().trim().split("\\s+");
        for (int i = 0; i < M; i++) {
            U[i] = Integer.parseInt(l2[i]);
            V[i] = Integer.parseInt(l3[i]);
            W[i] = Integer.parseInt(l4[i]);
        }

        ArrayList<Edge>[] graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            graph[U[i]].add(new Edge(U[i], V[i], W[i]));
        }

        dijkstra(graph, N, S, D);
    }

    static void dijkstra(ArrayList<Edge>[] graph, int N, int S, int D) {
        long[] dist = new long[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[S] = 0;

        int[] parent = new int[N + 1]; // to track the path -> to print the stringPath
        Arrays.fill(parent, -1);

        boolean[] vis = new boolean[N + 1];

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(S, 0));

        while(!pq.isEmpty()) {
            Pair curr = pq.remove();

            if(vis[curr.node]) continue;
            vis[curr.node] = true;
        
            // relaxation
            for (Edge e : graph[curr.node]) {
                int u = e.src;
                int v = e.dest;
                long w = e.wt;

                if(dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.add(new Pair(v, dist[v]));
                    parent[v] = u;
                }
            }
        }

        // no path exists
        if(dist[D] == Long.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        System.out.println(dist[D]);
        printPath(parent, D);
        System.out.println();
    }

    // Reconstruct path
    static void printPath(int[] parent, int node) {
        if(node == -1) return;
        printPath(parent, parent[node]);
        System.out.print(node + " ");
    }

    static class Pair implements Comparable<Pair> {
        int node;
        long path;
        Pair(int node, long path) {
            this.node = node;
            this.path = path;
            // this.strPath = n + " " + path;
        }
        @Override
        public int compareTo(Pair p2) {
            return Long.compare(this.path, p2.path); // path based sorting for my pairs
        }
    }

    static class Edge {
        int src, dest, wt;
        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
}
