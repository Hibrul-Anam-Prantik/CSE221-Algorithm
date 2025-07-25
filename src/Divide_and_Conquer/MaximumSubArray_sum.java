package Divide_and_Conquer;

public class MaximumSubArray_sum {
    public static void main(String[] args) throws Exception {
        int[] a = {-1, -4, 7, -1, -2, 2, 6, -7};
        a = new int[] {2,-8,3,0,3,-4,3,0,-2,8};
        System.out.println(MSA(a, 0, a.length - 1));// Example array
        System.out.println("done");
    }

    static int MSA(int[]a, int l, int r) {
        if(l > r) {
            return Integer.MIN_VALUE;// Base case: if the left index exceeds the right index, return the minimum integer value
        }
        if(l == r) {
            return a[l];
        }
        int m = (l + r)/2;  // m = l + (r - l) / 2; //this midpoint avoids overflow
        int leftSum = MSA(a, l, m - 1);
        int rightSum = MSA(a, m + 1, r);
        int crossSum = CS(a, l, m, r);
        return Math.max(leftSum, Math.max(rightSum, crossSum));
    }
    static int CS(int[] a, int l, int m, int r) {
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        int sum = 0;

        // Calculate maximum-subarray-sum crossing the midpoint from the left
        for (int i = m; i >= l; i--) {
            sum += a[i];
            if (sum > leftMax) {
                leftMax = sum;
            }
        }

        sum = 0; // Reset sum for right side

        // Calculate maximum-subarray-sum crossing the midpoint from the right
        for (int i = m + 1; i <= r; i++) {
            sum += a[i];
            if (sum > rightMax) {
                rightMax = sum;
            }
        }

        return Math.max(leftMax + rightMax, Math.max(leftMax, rightMax));
    }
}
