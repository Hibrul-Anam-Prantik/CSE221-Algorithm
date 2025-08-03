import java.util.LinkedList;

public class B__ {
    public static void main(String[] args) throws Exception {
        java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        String [] line1 = br.readLine().split(" ");
        int N = Integer.parseInt(line1[0]), M = Integer.parseInt(line1[1]);

        int[] u = new int[M], v = new int[M], w = new int[M];

        String uElem[] = br.readLine().split(" ");
        String vElem[] = br.readLine().split(" ");
        String wElem[] = br.readLine().split(" ");
        for(int i = 0; i < M; ++i) {
            u[i] = Integer.parseInt(uElem[i]);
            v[i] = Integer.parseInt(vElem[i]);
            w[i] = Integer.parseInt(wElem[i]);
        }

        // LinkedList<Edge>[] adjList = new LinkedList<>[N + 1];
    }

    static class Edge {
        int vertex, weight;
        Edge(int v, int w) {
            vertex = v;
            weight = w;
        }
    }
}
