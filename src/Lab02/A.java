package Lab02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
// import java.io.IOException;  I can do this & throw "IOException", but it's not necessary here as I am throwing "Exception" in the main method.
// Won't be using Scanner for this problem as BufferedReader is more efficient for large inputs and faster.
public class A {
    public static void main(String[] args) throws Exception {
        // Using BufferedReader for fast input to maintain the time limit.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read N and S from the 1st line of the user input
        String[] userInput = br.readLine().split(" ");
        int N = Integer.parseInt(userInput[0]);
        int S = Integer.parseInt(userInput[1]);

        int[] arr = new int[N];
        // Read the array (elements) from the 2nd line of the user input
        String[] secondLine = br.readLine().split(" ");
        for (int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(secondLine[i]);
        }

        // searching -> TwoPointer Technique
        int start = 0, end = N - 1;
        while (start < end) {
            int sum = arr[start] + arr[end];
            if (sum == S) {
                System.out.println((start + 1) + " " + (end + 1));
                return;  // pair found, exit the program
            } else if (sum < S) {  // if the sum is less than S, move the start pointer to the right to increase the sum
                start++;
            } else {   // if the sum is greater than S, move the end pointer to the left to decrease the sum
                end--;
            }
        }

        System.out.println(-1); // no pair found
        br.close(); // Closing the BufferedReader
    }
}


//public class A {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt(), S = sc.nextInt();
//        int[] arr = new int[N];
//        // N integers will be given in sorted order (ascending)
//        for (int i = 0; i < N; i++) {
//            arr[i] = sc.nextInt();
//        }
//
//        int start = 0, end = N - 1;
//        while(start < end) {
//            int sum = arr[start] + arr[end];
//            if (sum == S) {
//                System.out.println((start + 1) + " " + (end + 1));
//                return;  // pair found, exit the program
//            } else if(sum < S) {
//                start ++;
//            } else {
//                end --;
//            }
//        }
//        System.out.println(-1); // no pair found
//        sc.close();
//    }
//}
