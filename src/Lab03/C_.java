package Lab03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class C_ {
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
    private static BigInteger modularExponentiation(int a, long b, int mod) {
        BigInteger result = BigInteger.ONE;
        BigInteger base = BigInteger.valueOf(a);
//        BigInteger power = BigInteger.valueOf(b);
        BigInteger modulus = BigInteger.valueOf(mod);
        // Using BigInteger for large numbers -> if a or b is large, we can use BigInteger to handle it and avoid overflow
        base = base.mod(modulus);
//        long power = b; // using int for power since we are not expecting it to be too large

        while(b > 0) {
            if((b & 1) == 1) {
                result = result.multiply(base).mod(modulus); // if b is odd, multiply the result by a -> then mod it
            }
            base = base.multiply(base).mod(modulus); // square the base
            b >>= 1; // this is similar to b /= 2, it shifts the bits of b to the right by 1 position
        }
        return result;
    }
}