import java.util.ArrayList;
import java.util.List;

public class B__ {
    public static void main(String[] args) throws Exception {
        java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        int N = Integer.parseInt(line1[0]), M = Integer.parseInt(line1[1]);

        int[] u = new int[M], v = new int[M], w = new int[M];

        String uElem[] = br.readLine().trim().split("\\s+");
        String vElem[] = br.readLine().trim().split("\\s+");
        String wElem[] = br.readLine().trim().split("\\s+");
        for (int i = 0; i < M; ++i) {
            u[i] = Integer.parseInt(uElem[i]);
            v[i] = Integer.parseInt(vElem[i]);
            w[i] = Integer.parseInt(wElem[i]);
        }
        // add to the graph
        List<List<Edge>> adjList = new ArrayList<>(N + 1); // List of lists -> contains edges
        // Initializing each list
        for (int i = 0; i <= N; ++i) adjList.add(new ArrayList<>());  // indices 0,...,N
        
        // adding edges to the graph
        for (int i = 0; i < M; ++i) adjList.get(u[i]).add(new Edge(v[i], w[i]));
        
        // print the graph
        for (int i = 1; i <= N; i++) {
            System.out.print(i + ":");
            for (Edge e : adjList.get(i)) {
                System.out.print("(" + e.vertex + "," + e.weight + ") ");
            }
            System.out.println();
        }
        br.close();
    }

    // Helper class to represent a pair/Edges (vertex, weight)
    static class Edge {
        int vertex, weight;

        Edge(int v, int w) {
            vertex = v;
            weight = w;
        }
    }
}
