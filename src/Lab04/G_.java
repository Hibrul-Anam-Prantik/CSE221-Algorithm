import java.util.HashSet;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class G_ {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().trim().split("\\s+");
        int N = Integer.parseInt(firstLine[0]);
        int M = Integer.parseInt(firstLine[1]);
        int K = Integer.parseInt(firstLine[2]);

        // Use a Set to store positions of knights (row * 10000 + col to make it unique)
        HashSet<Integer> knights = new HashSet<>();
        ArrayList<int[]> knightPositions = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            String[] pos = br.readLine().trim().split("\\s+");
            int x = Integer.parseInt(pos[0]);
            int y = Integer.parseInt(pos[1]);
            knightPositions.add(new int[]{x, y});
            knights.add(x * 10000 + y);  // Encode position into a single number
        }

        // Knight move directions
        int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
        int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};

        for (int[] pos : knightPositions) {
            int x = pos[0];
            int y = pos[1];

            for (int d = 0; d < 8; d++) {
                int newX = x + dx[d];
                int newY = y + dy[d];

                // Check bounds
                if (newX >= 1 && newX <= N && newY >= 1 && newY <= M) {
                    if (knights.contains(newX * 10000 + newY)) {
                        System.out.println("YES");
                        br.close();
                        return;
                    }
                }
            }
        }

        System.out.println("NO");
        br.close();
    }
}
