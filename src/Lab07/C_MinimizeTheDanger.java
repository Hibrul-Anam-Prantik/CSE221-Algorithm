package Lab07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class C_MinimizeTheDanger {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] l1 = br.readLine().trim().split("\\s+");
        int N = Integer.parseInt(l1[0]), M = Integer.parseInt(l1[1]);

        ArrayList<Edge>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            String[] line = br.readLine().trim().split("\\s+");
            int u = Integer.parseInt(line[0]);
            int v = Integer.parseInt(line[1]);
            int w = Integer.parseInt(line[2]);
            graph[u].add(new Edge(u, v, w));
            graph[v].add(new Edge(v, u, w));  // bi-directed roads -> undirected graph
        }

        dijkstra(graph, N);
    }

    static void dijkstra(ArrayList<Edge>[] graph, int N) {
        long[] dist = new long[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;

        boolean[] vis = new boolean[N + 1];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(1, 0));

        while(!pq.isEmpty()) {
            Pair curr = pq.remove();

            if(vis[curr.node]) continue;
            vis[curr.node] = true;

            for(Edge e : graph[curr.node]) {
                int u = e.src;
                int v = e.dest;
                long w = e.wt;

                long maxDLvl = Math.max(dist[u], w);

                if(maxDLvl < dist[v]) {
                    dist[v] = maxDLvl;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        // printing result
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if(dist[i] == Long.MAX_VALUE) sb.append(-1).append(" ");
            else sb.append(dist[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    static class Pair implements Comparable<Pair> {
        int node;
        long dLvl;
        Pair(int n, long lvl) {
            node =n;
            dLvl = lvl;
        }
        @Override
        public int compareTo(Pair p) {
            return Long.compare(this.dLvl, p.dLvl);
        }
    }

    static class Edge {
        int src, dest, wt;
        Edge(int s, int d, int w) {
            src = s; dest = d; wt = w;
        }
    }
}
