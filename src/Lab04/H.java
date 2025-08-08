import java.util.ArrayList;

public class H {
    public static void main(String[] args) throws Exception {
        java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));

        String[] line1 = br.readLine().trim().split("\\s+");  // read first line and split by whitespace --> handles multiple spaces --> more proficiency 
        int N = Integer.parseInt(line1[0]);
        int Q = Integer.parseInt(line1[1]);

        // coprime graph --> adjacency list --> ArrayList of ArrayLists
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j && gcd(i, j) == 1) {
                    graph.get(i).add(j);
                }
            }
            java.util.Collections.sort(graph.get(i));  // sorting neighbors for consistent output --> easy access by index
        }

        StringBuilder result = new StringBuilder();  // to store outputs
        // queries
        for (int q = 0; q < Q; q++) {
            String[] query = br.readLine().split(" ");
            int X = Integer.parseInt(query[0]);
            int K = Integer.parseInt(query[1]);

            ArrayList<Integer> neighbors = graph.get(X);
            if (K <= neighbors.size()) {
                result.append(neighbors.get(K - 1)).append("\n");
            } else {
                result.append("-1\n");
            }
        }

        System.out.print(result.toString());
        br.close();
    }

    // helper function to calc GCD
    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
