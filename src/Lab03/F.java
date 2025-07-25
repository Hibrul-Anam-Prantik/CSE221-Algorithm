package Lab03;

import java.io.*;
import java.util.*;

public class F {

    static void buildOrder(int[] arr, int left, int right, List<Integer> res) {
        if (left > right) return;

        int mid = (left + right) / 2;
        res.add(arr[mid]);
        buildOrder(arr, left, mid - 1, res);
        buildOrder(arr, mid + 1, right, res);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> result = new ArrayList<>();
        buildOrder(arr, 0, n - 1, result);

        // Print result
        StringBuilder sb = new StringBuilder();
        for (int val : result) {
            sb.append(val).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}

