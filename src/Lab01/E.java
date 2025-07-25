package Lab01;

import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        // sorting the array
        for (int j = 0; j < N; j++) {
            for (int i = 0; i <= N - 3; i++) {
                if (arr[i] > arr[i + 2]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 2];
                    arr[i + 2] = temp;
                }
            }
        }

        // checking if sorted
        boolean sorted = true;
        for (int i = 1; i < N; i++) {
            if (arr[i] < arr[i - 1]) {
                sorted = false;
                break;
            }
        }

        System.out.println(sorted ? "YES" : "NO");
    }
}