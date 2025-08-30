package Lab07;

import java.io.*;
import java.util.*;

public class E_ParityEdges {
    static class Edge {
        int to;
        int w;
        Edge(int t, int wt) {
            to = t;
            w = wt;
        }
    }

    static class State implements Comparable<State> {
        int node, parity;
        long dist;
        State(int n, int p, long d) {
            node = n; parity = p; dist = d;
        }
        public int compareTo(State o) {
            return Long.compare(this.dist, o.dist);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] l1 = br.readLine().trim().split("\\s+");
        int N = Integer.parseInt(l1[0]);
        int M = Integer.parseInt(l1[1]);

        String[] uStr = br.readLine().trim().split("\\s+");
        String[] vStr = br.readLine().trim().split("\\s+");
        String[] wStr = br.readLine().trim().split("\\s+");

        // adjacency list
        ArrayList<Edge>[] graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int u = Integer.parseInt(uStr[i]);
            int v = Integer.parseInt(vStr[i]);
            int w = Integer.parseInt(wStr[i]);
            graph[u].add(new Edge(v, w));
        }

        // dist[node][parity]
        long[][] dist = new long[N+1][2];
        for (int i = 1; i <= N; i++) Arrays.fill(dist[i], Long.MAX_VALUE);

        PriorityQueue<State> pq = new PriorityQueue<>();

        // From node 1, we can try all outgoing edges
        dist[1][0] = dist[1][1] = 0; // start with cost 0 (no edge taken yet)
        pq.add(new State(1, 0, 0));
        pq.add(new State(1, 1, 0));

        while (!pq.isEmpty()) {
            State curr = pq.poll();
            int u = curr.node;
            int p = curr.parity;
            long d = curr.dist;

            if (d != dist[u][p]) continue; // stale state

            for (Edge e : graph[u]) {
                int newParity = e.w % 2;
                if (newParity == p) continue; // must alternate

                long nd = d + e.w;
                if (nd < dist[e.to][newParity]) {
                    dist[e.to][newParity] = nd;
                    pq.add(new State(e.to, newParity, nd));
                }
            }
        }

        long ans = Math.min(dist[N][0], dist[N][1]);
        System.out.println(ans == Long.MAX_VALUE ? -1 : ans);
    }
}
