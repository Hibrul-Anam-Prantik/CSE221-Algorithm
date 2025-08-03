public class B_ {
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
        // add to the graph
        Graph g = new Graph(N + 1); // 1-based indexing
        for(int i = 0; i < M; ++i) {
            g.addEdge(u[i], v[i], w[i]);
        }
        // print the graph
        for(int i = 1; i <= N; ++i) {
            System.out.print(i + ": ");
            Edge cur = g.edges[i];
            while(cur != null) {
                System.out.print("(" + cur.vertex + "," + cur.weight + ") ");
                cur = cur.next;
            }
            System.out.println();
        }
    }

    static class Graph {
        int N; // size of the graph
        Edge[] edges; // array of edges or nodes, to store and link the nodes

        Graph(int N) {
            this.N = N;
            edges = new Edge[N + 1]; // 1-based indexing
        }

        void addEdge(int src, int dest, int w) {
            Edge destEdge = new Edge(dest, w);
            destEdge.next = edges[src]; // add to the front of the list
            edges[src] = destEdge; // update the head of the list
        }
    }

    static class Edge {
        int vertex, weight;
        Edge next; // pointer to the next edge

        Edge(int v, int w) {
            vertex = v;
            weight = w;
            next = null;
        
        }
    }
}