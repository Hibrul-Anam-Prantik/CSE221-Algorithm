package Lab02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class D {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line01 = br.readLine().split(" ");
        int N = Integer.parseInt(line01[0]); // Size of the 1st array
        int[] arr1 = new int[N]; // 1st array sorted (ascending) of size N
        String[] elements1 = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(elements1[i]);
        }
        String[] line02 = br.readLine().split(" ");
        int M = Integer.parseInt(line02[0]); // Size of the 2nd array
        int[] arr2 = new int[M]; // 2nd array sorted (ascending) of size M
        String[] elements2 = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            arr2[i] = Integer.parseInt(elements2[i]);
        }
        int[] mergedArr = new int[N + M]; // Merged-array of size N + M
        int i = 0, j = 0, newI = 0;
        // sorting and merging the two arrays of till the size is common
        while(i < N && j < M) {
            if(arr1[i] <= arr2[j]) mergedArr[newI++] = arr1[i++];
            else mergedArr[newI++] = arr2[j++];
        }
        // sorting and merging the remaining elements of both arrays (if any exists)
        while(i < N) mergedArr[newI++] = arr1[i++];
        while(j < M) mergedArr[newI++] = arr2[j++];

        // Printing the merged array
//        for(int element : mergedArr) {
//            System.out.print(element + " ");
//        }
        // Using StringBuilder for fast output
        StringBuilder sb = new StringBuilder();
        for (int val : mergedArr) {
            sb.append(val).append(" ");
        }
        System.out.println(sb);

        br.close();
    }
}
