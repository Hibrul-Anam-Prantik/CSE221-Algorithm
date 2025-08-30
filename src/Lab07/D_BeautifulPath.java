package Lab07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class D_BeautifulPath {
    static class Pair implements Comparable<Pair> {
        int node;
        long cost;
        Pair(int n, long c) {
            node = n;
            cost = c;
        }
        public int compareTo(Pair o) {
            return Long.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] l1 = br.readLine().trim().split("\\s+");
        int N = Integer.parseInt(l1[0]);
        int M = Integer.parseInt(l1[1]);
        int S = Integer.parseInt(l1[2]);
        int D = Integer.parseInt(l1[3]);

        // node weights
        String[] wStr = br.readLine().trim().split("\\s+");
        long[] weight = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            weight[i] = Long.parseLong(wStr[i - 1]);
        }

        // adjacency list
        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String[] edge = br.readLine().trim().split("\\s+");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);
            graph[u].add(v); // directed edge
        }

        // run modified Dijkstra
        long[] dist = new long[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[S] = weight[S];  // cost starts with weight of source

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(S, dist[S]));

        boolean[] vis = new boolean[N + 1];

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.node;
            if (vis[u]) continue;
            vis[u] = true;

            for (int v : graph[u]) {
                if (dist[v] > dist[u] + weight[v]) {
                    dist[v] = dist[u] + weight[v];
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        if (dist[D] == Long.MAX_VALUE) System.out.println(-1);
        else System.out.println(dist[D]);
    }
}
