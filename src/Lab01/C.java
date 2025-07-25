package Lab01;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 0; i < T; ++i) {
            int N = sc.nextInt();
            // long sum = (long) N * (N + 1) / 2;
            // using long to avoid Integer overflow!
            // formula-> from 1 to n -> summation = n * (n + 1)/2
            System.out.println((long) N * (N + 1) / 2);
        }
        sc.close();
    }
}