package Lab02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] first = br.readLine().split(" ");
        int n = Integer.parseInt(first[0]);
        int q = Integer.parseInt(first[1]);

        int[] arr = new int[n];
        String[] line = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }

        StringBuilder sb = new StringBuilder();

        while (q-- > 0) {
            String[] query = br.readLine().split(" ");
            int x = Integer.parseInt(query[0]);
            int y = Integer.parseInt(query[1]);

            int left = lowerBound(arr, x);
            int right = upperBound(arr, y);

            sb.append(right - left).append('\n');
        }

        System.out.print(sb);
        br.close();
    }

    // Finds first index where arr[i] >= x
    private static int lowerBound(int[] arr, int x) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] < x) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    // Finds first index where arr[i] > y
    private static int upperBound(int[] arr, int y) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] <= y) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}
