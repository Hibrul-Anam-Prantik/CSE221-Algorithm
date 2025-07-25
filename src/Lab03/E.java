package Lab03;

import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class E {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            BigInteger a = new BigInteger(st.nextToken());
            long n = Long.parseLong(st.nextToken());
            BigInteger m = new BigInteger(st.nextToken());

            if (a.equals(BigInteger.ONE)) {
                // sum = n % m
                sb.append(BigInteger.valueOf(n).mod(m)).append('\n');
                continue;
            }

            BigInteger aMinus1 = a.subtract(BigInteger.ONE);
            BigInteger modVal = m.multiply(aMinus1);

            // Compute a^(n+1) mod modVal using BigInteger.modPow
            BigInteger pow = a.modPow(BigInteger.valueOf(n + 1), modVal);

            // numerator = (a^(n+1) - a) mod modVal
            BigInteger numerator = pow.subtract(a);
            if (numerator.signum() < 0) numerator = numerator.add(modVal);

            // Divide numerator by (a-1)
            BigInteger ans = numerator.divide(aMinus1).mod(m);

            sb.append(ans).append('\n');
        }

        System.out.print(sb);
    }
}


/* TLE
public class E {
    public static void main(String[] args) throws Exception {
        java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // Read the number of test cases

        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            long n = Long.parseLong(input[1]);
            int m = Integer.parseInt(input[2]);

            long ans;
            if (a == 1) ans = n % m; // if a is 1, then the sum is simply n % m
            else {
                long pow = modularExponentiation(a, n + 1, m);
                long numerator = (pow - a + m) % m;
                long denominatorInverse = modularInverse(a - 1, m);
                ans = (numerator * denominatorInverse) % m;
            }
            System.out.println(ans);
        }
        br.close();
    }

//    Time Limit Exceeds
//    private static long doCalc(int a, long n, int m) {
//        long result = 0;
//        for (int i = 1; i <= n; i++) {
//            result += (modularExponentiation(a, i, m) % m);
//        }
//        return result % m;
//    }

    private static long modularExponentiation(int a, long b, int mod) {
        long result = 1;
        a = a % mod; // taking a mod to avoid overflow -> fast exponentiation works with smaller numbers

        while (b > 0) {
            if ((b & 1) == 1) {
                result = result * a % mod; // if b is odd, multiply the result by a -> then mod it
            }
            a = a * a % mod; // square the base
            b >>= 1; // this is similar to b /= 2, it shifts the bits of b to the right by 1 position
        }
        return result;
    }

    // Modular inverse using Fermat's Little Theorem (only works if m is prime)
    private static long modularInverse(int a, int mod) {
        return modularExponentiation(a, mod - 2, mod);
    }
}
 */
