public class E {
public static void main(String[] args) throws Exception {
        java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        String[] l1 = br.readLine().split(" ");
        int N = Integer.parseInt(l1[0]), M = Integer.parseInt(l1[1]);

        int[] u = new int[M], v = new int[M];

        String[] uLine = br.readLine().split(" "), vLine = br.readLine().split(" ");

        for (int i = 0; i < M; i++) {
            u[i] = Integer.parseInt(uLine[i]);
            v[i] = Integer.parseInt(vLine[i]);
        }

        int[] inDegree = new int[N + 1], outDegree = new int[N + 1];  // 1-based indexing
        for (int i = 0; i < M; i++) {
            outDegree[u[i]]++;
            inDegree[v[i]]++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; ++i) {
            sb.append(inDegree[i] - outDegree[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
        br.close();
    }
}
