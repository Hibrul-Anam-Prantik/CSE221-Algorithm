package Lab01;

import java.util.Scanner;

public class F {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; ++i) {
            arr[i] = sc.nextInt();
        }
        for (int i = 1; i < arr.length; ++i) {
            int j = i;
            while (j > 0) {
                if ((arr[j] % 2 == arr[j - 1] % 2) && (arr[j] < arr[j - 1])) {
                    swap(arr, j, j - 1);
                    --j;
                } else {
                    break;
                }
            }
        }
        printArray(arr);
        sc.close();
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
    }
}
