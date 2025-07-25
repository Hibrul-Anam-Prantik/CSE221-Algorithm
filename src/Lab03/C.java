package Lab03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class C {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        long b = Long.parseLong(input[1]);  // taking b as long as the question mentioned 1 <= b <= 10^12; which doesn't fit in integer
        int mod = 107; // given
        // have to calculate a^b % mod
        System.out.println(modularExponentiation(a, b, mod));
        br.close();
    }

    // modular exponentiation -> (a^b) % mod = ((a % mod) ^ b) % mod
    private static int modularExponentiation(int a, long b, int mod) {
        int result = 1;
        a = a % mod; // taking a mod to avoid overflow -> fast exponentiation works with smaller numbers

        while(b > 0) {
            if((b & 1) == 1) {
                result = result * a % mod; // if b is odd, multiply the result by a -> then mod it
            }
            a = a * a % mod; // square the base
            b >>= 1; // this is similar to b /= 2, it shifts the bits of b to the right by 1 position
        }
        return result;
    }
}
