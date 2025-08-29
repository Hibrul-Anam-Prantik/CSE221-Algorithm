package Lab07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class B_WhereToMeet {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] l1 = br.readLine().trim().split("\\s+");
        int N = Integer.parseInt(l1[0]), M = Integer.parseInt(l1[1]);
        int S = Integer.parseInt(l1[2]), T = Integer.parseInt(l1[3]);
        // adjLust init ->
        ArrayList<Edge>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            graph[i] = new ArrayList<>();
        // reading edges
        for (int i = 0; i < M; i++) {
            String[] line = br.readLine().trim().split("\\s+");
            int u = Integer.parseInt(line[0]);
            int v = Integer.parseInt(line[1]);
            int w = Integer.parseInt(line[2]);
            graph[u].add(new Edge(u, v, w));
        }
        // Dijkstra -> Alice | Starting from S
        long[] distAlice = dijkstra(graph, N, S);
        // Dijkstra -> Bob | Starting from T
        long[] distBob = dijkstra(graph, N, T);
        // now searching for the meeting node with the minimum time as asked
        long minTime = Long.MAX_VALUE;
        int meetNode = -1; // meeting node -1 => no such node

        for (int i = 1; i <= N; i++) {
            // reachable nodes for both of them
            if (distAlice[i] != Long.MAX_VALUE && distBob[i] != Long.MAX_VALUE) {
                long t = Math.max(distAlice[i], distBob[i]);
                // updating the minimum time & for multiple same matches
                // will choose the smallest node among them
                if (t < minTime || (t == minTime && i < meetNode)) {
                    minTime = t;
                    meetNode = i;
                }
            }
        }

        // printing the output -> result
        if (meetNode == -1)
            System.out.println(-1);
        else
            System.out.println(minTime + " " + meetNode);
    }

    // Dijkstra Algo -> returns distances from source
    static long[] dijkstra(ArrayList<Edge>[] graph, int N, int src) {
        long[] dist = new long[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[src] = 0;

        boolean[] vis = new boolean[N + 1];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (vis[curr.node])
                continue; // already done -> skip
            vis[curr.node] = true;

            // relaxation
            for (Edge e : graph[curr.node]) {
                int u = e.src;
                int v = e.dest;
                int w = e.wt;

                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }
        return dist;
    }

    static class Edge {
        int src, dest, wt;

        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static class Pair implements Comparable<Pair> {
        int node;
        long path;

        Pair(int node, long path) {
            this.node = node;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p) {
            return Long.compare(this.path, p.path);
        }
    }
}
