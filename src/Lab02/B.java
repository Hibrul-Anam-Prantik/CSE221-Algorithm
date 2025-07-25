package Lab02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read the first line containing 3 integers N, M & K
        String[] line01 = br.readLine().split(" ");
        int N = Integer.parseInt(line01[0]); // Size of array A
        int M = Integer.parseInt(line01[1]); // Size of array B
        int K = Integer.parseInt(line01[2]); // The value to be deducted from |A[i] + B[j]|

        // Read the second line containing the elements of array A
        int[] A = new int[N]; // Array A of size N, sorted in ascending order
        String[] line02 = br.readLine().split(" ");
        // Read the third line containing the elements of array A
        int[] B = new int[M]; // Array B of size M, sorted in ascending order
        String[] line03 = br.readLine().split(" ");
        // inserting the elements of array A & B
        for (int i = 0; i < N; ++i) {
            A[i] = Integer.parseInt(line02[i]);
        }
        for (int i = 0; i < M; ++i) {
            B[i] = Integer.parseInt(line03[i]);
        }

        if (N < 2 && M < 2) {
            System.out.println(1 + " " + 1);  // If both arrays have only 1 element, return 1 1
            return; // exit the program
        }
        // do otherwise -> Two pointer technique
        int i = 0, j = M - 1; // i points to the start of array A, j points to the end of array B
        int minDiff = Integer.MAX_VALUE; // minimum difference
        int targetI = 0, targetJ = 0; // to store the indices of the closest pair
        while (i < N && j >= 0){
            int sum = A[i] + B[j];
            int tempDiff = Math.abs(sum - K);  //the sum A[i] + B[j] is closest to K (i.e., it minimizes |A[i] + B[j] − K|)
            if (tempDiff < minDiff) {
                minDiff = tempDiff; // Update the minimum difference
                targetI = i;
                targetJ = j; // Update the target indices
            }
            if(sum < K) i ++;
            else if(sum > K) j --;
            else {
                System.out.println((i + 1) + " " + (j + 1));
                return; // If the sum is equal to K, print the indices and exit
            }
        }
        System.out.println((targetI + 1) + " " + (targetJ + 1)); // adding 1 to convert 0-based index to 1-based index
        br.close();
    }
}
