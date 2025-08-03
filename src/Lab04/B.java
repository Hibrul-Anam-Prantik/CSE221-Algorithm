public class B {
    public static void main(String[] args) throws Exception {
        java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        int N = Integer.parseInt(line1[0]);
        int M = Integer.parseInt(line1[1]);

        int[] u = new int[M];
        int[] v = new int[M];
        int[] w = new int[M];

        String[] uLine = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            u[i] = Integer.parseInt(uLine[i]);
        }

        String[] vLine = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            v[i] = Integer.parseInt(vLine[i]);
        }

        String[] wLine = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            w[i] = Integer.parseInt(wLine[i]);
        }

        Graph g = new Graph(N + 1); // 1-based indexing

        // initialize adjList[i] directly at the correct index
        for (int i = 1; i <= N; i++) {
            g.adjList[i] = new Node(i);
        }

        for (int i = 0; i < M; i++) {
            g.addEdge(u[i], v[i], w[i]);
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(i + ":");
            Node curr = g.adjList[i].next;
            while (curr != null) {
                System.out.print(" (" + curr.vertex + "," + curr.weight + ")");
                curr = curr.next;
            }
            System.out.println();
        }
    }

    static class Graph {
        int size;
        Node[] adjList;

        public Graph(int size) {
            this.size = size;
            adjList = new Node[size];
        }

        public void addEdge(int src, int dest, int weight) {
            Node destNode = new Node(dest);
            destNode.weight = weight;
            destNode.next = adjList[src].next;
            adjList[src].next = destNode;
        }
    }

    static class Node {
        int vertex, weight;
        Node next;

        Node(int v) {
            vertex = v;
            next = null;
        }
    }
}
