import java.io.*;
import java.util.*;

public class Testing {
    static class Edge {
        int dest, wt;
        Edge(int d, int w) { dest = d; wt = w; }
    }

    static class Pair implements Comparable<Pair> {
    int node;
    long dist;
    Pair(int node, long dist) { this.node = node; this.dist = dist; }
    public int compareTo(Pair p) { return Long.compare(this.dist, p.dist); } // <- fix
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first = br.readLine().split(" ");
        int n = Integer.parseInt(first[0]);
        int m = Integer.parseInt(first[1]);
        int S = Integer.parseInt(first[2]);
        int T = Integer.parseInt(first[3]);

        ArrayList<Edge>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            int u = Integer.parseInt(line[0]);
            int v = Integer.parseInt(line[1]);
            int w = Integer.parseInt(line[2]);
            graph[u].add(new Edge(v, w));
        }

        long[] distAlice = dijkstra(graph, n, S);
        long[] distBob = dijkstra(graph, n, T);

        long minTime = Long.MAX_VALUE;
        int meetNode = -1;

        for (int i = 1; i <= n; i++) {
            if (distAlice[i] != Long.MAX_VALUE && distBob[i] != Long.MAX_VALUE) {
                long t = Math.max(distAlice[i], distBob[i]);
                if (t < minTime || (t == minTime && i < meetNode)) {
                    minTime = t;
                    meetNode = i;
                }
            }
        }

        if (meetNode == -1) {
            System.out.println(-1);
        } else {
            System.out.println(minTime + " " + meetNode);
        }
    }

    static long[] dijkstra(ArrayList<Edge>[] graph, int n, int src) {
        long[] dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        boolean[] vis = new boolean[n + 1];
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        dist[src] = 0;
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int node = cur.node;
            if (vis[node]) continue;
            vis[node] = true;

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
