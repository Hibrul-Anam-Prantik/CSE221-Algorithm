package Lab02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class H {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            String[] parts = br.readLine().split(" ");
            long k = Long.parseLong(parts[0]);
            long x = Long.parseLong(parts[1]);

            long low = 1, high = 2 * k;  // high is safe since at worst every x-th number is skipped

            while (low < high) {
                long mid = (low + high) / 2;
                long count = mid - (mid / x); // count of numbers not divisible by x
                if (count < k) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }

            sb.append(low).append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
