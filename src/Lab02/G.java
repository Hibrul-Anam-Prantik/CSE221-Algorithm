package Lab02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read n and q
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        // Read the sorted array
        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        // Process each query
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int left = lowerBound(a, x);
            int right = upperBound(a, y);

            sb.append(right - left).append('\n');
        }

        System.out.print(sb);
        br.close();
    }

    // First index with value >= x
    private static int lowerBound(int[] a, int x) {
        int low = 0, high = a.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (a[mid] < x)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    // First index with value > y
    private static int upperBound(int[] a, int y) {
        int low = 0, high = a.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (a[mid] <= y)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
}
