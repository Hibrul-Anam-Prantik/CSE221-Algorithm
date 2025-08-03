public class A {
    public static void main(String[] args) throws Exception {
        java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        String line1[] = br.readLine().split(" ");
        int N = Integer.parseInt(line1[0]), M = Integer.parseInt(line1[1]);
        Graph g = new Graph(N);
        for(int i = 0; i < M; ++i) {
            String nodes[] = br.readLine().split(" ");
            g.addEdge(Integer.parseInt(nodes[0]) - 1, Integer.parseInt(nodes[1]) - 1, Integer.parseInt(nodes[2]));
            // -------->  1-indexing -> -1
        }
        g.printGraph();
    }

    static class Graph {
        int n;
        int matrix[][];

        Graph(int N) {
            matrix = new int[N][N];
            n = N;
        }
        void addEdge(int src, int dest, int wgt) {
            matrix[src][dest] = wgt;  // directed graph
        }
        void printGraph() {
            for(int i = 0; i < n; ++i) {
                for(int j = 0; j < n; ++j) {
                    System.out.print(matrix[i][j] + " "); // 1-indexing -> +1
                }
                System.out.println();
            }
        }
    }
}