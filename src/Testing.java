import java.io.*;
import java.util.*;

public class Testing {

    // Edge class for the graph
    static class Edge {
        int dest, wt;  // destination node and weight
        Edge(int d, int w) { dest = d; wt = w; }
    }

    // Pair class for the priority queue in Dijkstra
    static class Pair implements Comparable<Pair> {
        int node;
        long dist; // distance from source
        Pair(int node, long dist) { this.node = node; this.dist = dist; }

        // Sorting in PQ by distance
        public int compareTo(Pair p) {
            return Long.compare(this.dist, p.dist);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read n, m, S (Alice), T (Bob)
        String[] first = br.readLine().split(" ");
        int n = Integer.parseInt(first[0]);
        int m = Integer.parseInt(first[1]);
        int S = Integer.parseInt(first[2]);
        int T = Integer.parseInt(first[3]);

        // Initialize adjacency list for directed graph
        ArrayList<Edge>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        // Read edges
        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            int u = Integer.parseInt(line[0]);
            int v = Integer.parseInt(line[1]);
            int w = Integer.parseInt(line[2]);
            graph[u].add(new Edge(v, w));
        }

        // Run Dijkstra from Alice's start
        long[] distAlice = dijkstra(graph, n, S);

        // Run Dijkstra from Bob's start
        long[] distBob = dijkstra(graph, n, T);

        // Find the meeting node with minimum time
        long minTime = Long.MAX_VALUE;
        int meetNode = -1;

        for (int i = 1; i <= n; i++) {
            // Node reachable by both Alice and Bob
            if (distAlice[i] != Long.MAX_VALUE && distBob[i] != Long.MAX_VALUE) {
                long t = Math.max(distAlice[i], distBob[i]);
                // Update minimum time and choose smallest node in case of tie
                if (t < minTime || (t == minTime && i < meetNode)) {
                    minTime = t;
                    meetNode = i;
                }
            }
        }

        // Print result
        if (meetNode == -1) {
            System.out.println(-1);
        } else {
            System.out.println(minTime + " " + meetNode);
        }
    }

    // Dijkstra algorithm returning distances from source
    static long[] dijkstra(ArrayList<Edge>[] graph, int n, int src) {
        long[] dist = new long[n + 1]; // distance array
        Arrays.fill(dist, Long.MAX_VALUE);
        boolean[] vis = new boolean[n + 1]; // visited nodes

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        dist[src] = 0;
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int node = cur.node;
            if (vis[node]) continue; // already processed
            vis[node] = true;

            // Relax edges
            for (Edge e : graph[node]) {
                int v = e.dest;
                long nd = dist[node] + e.wt;
                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.add(new Pair(v, nd));
                }
            }
        }
        return dist;
    }
}
