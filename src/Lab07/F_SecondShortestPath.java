package Lab07;

import java.io.*;
import java.util.*;

public class F_SecondShortestPath {
    static class Edge {
        int to;
        int w;
        Edge(int t, int wt) { to = t; w = wt; }
    }

    static class State implements Comparable<State> {
        long dist;
        int node;
        State(long d, int n) { dist = d; node = n; }
        public int compareTo(State o) {
            return Long.compare(this.dist, o.dist);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] l1 = br.readLine().trim().split("\\s+");
        int N = Integer.parseInt(l1[0]);
        int M = Integer.parseInt(l1[1]);
        int S = Integer.parseInt(l1[2]);
        int D = Integer.parseInt(l1[3]);

        ArrayList<Edge>[] graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            String[] parts = br.readLine().trim().split("\\s+");
            int u = Integer.parseInt(parts[0]);
            int v = Integer.parseInt(parts[1]);
            int w = Integer.parseInt(parts[2]);
            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w)); // undirected
        }

        long INF = Long.MAX_VALUE / 2;
        long[] dist1 = new long[N+1];
        long[] dist2 = new long[N+1];
        Arrays.fill(dist1, INF);
        Arrays.fill(dist2, INF);

        PriorityQueue<State> pq = new PriorityQueue<>();
        dist1[S] = 0;
        pq.add(new State(0, S));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            long d = cur.dist;
            int u = cur.node;

            if (d > dist2[u]) continue;

            for (Edge e : graph[u]) {
                long nd = d + e.w;

                if (nd < dist1[e.to]) {
                    // Update both shortest and second shortest
                    dist2[e.to] = dist1[e.to];
                    dist1[e.to] = nd;
                    pq.add(new State(dist1[e.to], e.to));
                    if (dist2[e.to] < INF) pq.add(new State(dist2[e.to], e.to));
                } 
                else if (nd > dist1[e.to] && nd < dist2[e.to]) {
                    // Update second shortest only
                    dist2[e.to] = nd;
                    pq.add(new State(dist2[e.to], e.to));
                }
            }
        }

        System.out.println(dist2[D] >= INF ? -1 : dist2[D]);
    }
}
