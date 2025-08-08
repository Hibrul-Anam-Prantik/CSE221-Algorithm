import java.io.*;
import java.util.*;

public class H {
    static int N, Q;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        // Fast input and output
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        // Read N and Q
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        // Initialize graph
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build the graph: connect i to j if gcd(i, j) == 1 and i ≠ j
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j && gcd(i, j) == 1) {
                    graph[i].add(j);
                }
            }
            // Sort neighbors for fast access to K-th smallest
            Collections.sort(graph[i]);
        }

        // Process Q queries
        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            if (graph[X].size() < K) {
                out.write("-1\n");
            } else {
                out.write(graph[X].get(K - 1) + "\n");
            }
        }

        out.flush(); // flush the output
    }

    // Function to compute gcd
    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
