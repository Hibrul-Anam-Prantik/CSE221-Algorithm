import java.util.ArrayList;

public class G {
    public static void main(String[] args) throws Exception {
        java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        String[] line1 = br.readLine().trim().split("\\s+");
        int N = Integer.parseInt(line1[0]), M = Integer.parseInt(line1[1]), K = Integer.parseInt(line1[2]);

        ArrayList<ArrayList<Integer>> board = new ArrayList<>();
        // Initialize N rows, each with M columns
        for (int i = 0; i <= N; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j <= M; j++) {
                row.add(0); // default value 0 --> means no knight is present
            }
            board.add(row);
        }

        // List to store knight positions
        ArrayList<int[]> knights = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            String[] xy = br.readLine().trim().split("\\s+");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);

            board.get(x).set(y, 1); // 1 means there exists a knight
            knights.add(new int[]{x, y});
        }
        // Possible moves of a knight
        int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};  // change in row (up/down)
        int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};  // change in column (left/right)
        
        // checking for other knights
        for (int[] knight : knights) {
            int x = knight[0], y = knight[1];

            for (int d = 0; d < 8; d++) {  // dx.length/dy.length = 8
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 1 && nx <= N && ny >= 1 && ny <= M) {
                    if (board.get(nx).get(ny) == 1) {
                        System.out.println("YES");
                        return;
                    }
                }
            }
        }
        System.out.println("NO");
        br.close();
    }
}
