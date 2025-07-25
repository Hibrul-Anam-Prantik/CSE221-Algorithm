package Lab01;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; ++i) {
            int N = sc.nextInt();  // size of Array
//            sc.nextLine();
            int[] arr = new int[N];
//            String str = sc.nextLine();
//
//            int j = 0;
//            while(j < N * 2) {
//                String s = str.charAt(j) + "";
//                arr[j/2] = Integer.parseInt(s);
//                j += 2;
//            }
            for(int j = 0; j < N; ++j) {
                arr[j] = sc.nextInt();
            }
            boolean nonDecreasing = true;
            for(int j = 0; j < N - 1; ++j) {
                if(arr[j] > arr[j+1]) {
                    nonDecreasing = false;
                    break;
                }
            }
            if(nonDecreasing) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
