import java.util.ArrayList;
import java.util.List;

public class D {
    public static void main(String[] args) throws Exception {
        java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        int N = Integer.parseInt(line1[0]);
        int M = Integer.parseInt(line1[1]);
        String[] line2 = br.readLine().split(" ");
        String[] line3 = br.readLine().split(" ");
        List<List<Integer>> adjList = new ArrayList<>();
        // Initializing adjacency list --> counters the IndexOutOfBoundsException -->
        // when accessing adjList.get(i) for i from 1 to N.
        for(int i = 0; i <= N; ++i) adjList.add(new ArrayList<>());

        for(int i = 0; i < M; ++i) {
            int u = Integer.parseInt(line2[i]);
            int v = Integer.parseInt(line3[i]);
            adjList.get(u).add(v);
            adjList.get(v).add(u); // undirected graph
        }
        // Eulerian Path checking -> graph is connected & there are 0 or 2 vertices with "odd degree".

        int oddCount = 0;
        for(List<Integer> list : adjList) {
            if (list.size() % 2 != 0) {
                oddCount++;
            }
        }
        if (oddCount == 0 || oddCount == 2) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        br.close();
    }
}
