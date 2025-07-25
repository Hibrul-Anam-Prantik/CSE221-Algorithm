package BitBattle;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// E
public class Solutions {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line01 = br.readLine().split(" ");
        int n = Integer.parseInt(line01[0]);
        String[] line02 = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = Integer.parseInt(line02[i]);
        }

        for (int i = 1; i <= 1000000; ++i) {
            boolean isCursed = false;
            for (int j = 0; j < n; ++j) {
                if(i % arr[j] == 0) {
                    isCursed = true;
                    break;
                }
            }
            if(!isCursed) {
                System.out.println(i);
                return; // exit the program
            }
        }
        System.out.println(-1); // if no such number found
        br.close();
    }
}


// A
//import java.util.Scanner;
//public class Test{
//    public static void main(String[]args){
//        Scanner sc=new Scanner(System.in);
//        long N = sc.nextLong();  // as 2^30 isn't int
//        long books = N / 3;
//        if(N % 3 != 0) System.out.println((N / 3) + 1);
//        else System.out.println(Math.round(N / 3));
//        sc.close();
//    }
//}


// B
//public class Test {
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] line01 = br.readLine().split(" ");
//        int numRuhan = Integer.parseInt(line01[0]);
//        int numArman = Integer.parseInt(line01[1]);
//        // converting to binary String form -> to make life easier
//        String binRuhan = String.format("%10s", Integer.toBinaryString(numRuhan)).replace(' ', '0');
//        String binArman = String.format("%10s", Integer.toBinaryString(numArman)).replace(' ', '0');
//        System.out.println(binRuhan + " vs " + binArman);
//        int tie = 0, rWin = 0, aWin = 0;
//
//        for (int i = 0; i < binRuhan.length(); ++i) {
//            if(binArman.charAt(i) == binRuhan.charAt(binRuhan.length() - 1 - i)) {
//                tie++;
//            } else if (binArman.charAt(i) == '1' && binRuhan.charAt(binRuhan.length() - 1 - i) == '0') {
//                aWin++;
//            } else {
//                rWin++;
//            }
//        }
//        System.out.println("Ruhan: " + rWin);
//        System.out.println("Arman: " + aWin);
//        System.out.println("Tied: " + tie);
//        br.close();
//    }
//}


