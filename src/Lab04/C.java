import java.io.BufferedReader;

public class C {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Graph g = new Graph(N);
        for(int i = 0; i < N; ++i) {
            String[] list = br.readLine().split(" ");
            for(int j = 1; j <= Integer.parseInt(list[0]); ++j) {
                g.addEdge(i, Integer.parseInt(list[j]));
            }
        }
        g.printGraph();
        br.close();
    }

    static class Graph {
        int size;
        int[][] matrix;

        Graph(int size) {
            this.size = size;
            matrix = new int[size][size];
        }

        void addEdge(int src, int dest) {
            matrix[src][dest] = 1; // directed graph -> 1 -> edge exists
        }

        void printGraph() {
            for(int i = 0; i < size; ++i) {
                for(int j = 0; j < size; ++j) {
                    System.out.print(matrix[i][j]);
                    if (j < size - 1) System.out.print(" ");
                }
                System.out.println();
            }
        }
    }
}
