package Lab02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class F {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line01 = br.readLine().split(" ");
        int N = Integer.parseInt(line01[0]); // size of the array
        int K = Integer.parseInt(line01[1]); // the maximum number of distinct elements allowed
        int[] arr = new int[N]; // array of size N
        String[] elements = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(elements[i]); // inserting the elements of the array
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int start = 0, end = 0; // Two pointers
        int maxLength = 0; // to store the maximum length of the subarray
        while (end < N) {
            // Add the current element to the map
            map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);

            // If the size of the map exceeds K, shrink the window from the start
            while (map.size() > K) {
                map.put(arr[start], map.get(arr[start]) - 1);
                if (map.get(arr[start]) == 0) {
                    map.remove(arr[start]);
                }
                start++;
            }

            // Update the maximum length of the subarray
            maxLength = Math.max(maxLength, end - start + 1);
            end++;
        }
        System.out.println(maxLength); // Print the maximum length of the subarray with at most K distinct elements
        br.close();
    }
}
