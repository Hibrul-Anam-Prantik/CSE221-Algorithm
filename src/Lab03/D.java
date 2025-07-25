package Lab03;

public class D {
    static int mod = 1000000007;

    public static void main(String[] args) throws Exception {
        java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // Read the number of test cases
        for (int i = 0; i < T; i++) {
            int[] A = new int[4];
            String[] elems = br.readLine().split(" "); // Read the elements of the matrix
            for (int j = 0; j < 4; j++) {
                A[j] = Integer.parseInt(elems[j]);
            }
            int X = Integer.parseInt(br.readLine()); // Read exponent
            matrixExponentiation(A, X);
        }
        br.close();
    }

    static void matrixExponentiation(int[] mat, int x) {
        long[] result = new long[] {1, 0, 0, 1};  // Identity matrix
        long[] base = new long[4];
        for (int i = 0; i < 4; i++) base[i] = mat[i];

        // using fast exponentiation which works in O(logx)
        while (x > 0) {
            if ((x & 1) == 1) { // checking if x is odd -> Last bit is 1 -> Last step of exponentiation
                result = multiply(result, base);
            }
            base = multiply(base, base);  // squaring the base matrix
            x >>= 1;  // equivalent to x /= 2, right shift operation
        }

        // result
        System.out.println(result[0] + " " + result[1]);
        System.out.println(result[2] + " " + result[3]);
    }

    // Function to multiply two 2x2 matrices represented as long arrays, also modular arithmetic is applied
    static long[] multiply(long[] A, long[] B) {
        long[] res = new long[4];
        res[0] = (A[0] * B[0] % mod + A[1] * B[2] % mod) % mod;
        res[1] = (A[0] * B[1] % mod + A[1] * B[3] % mod) % mod;
        res[2] = (A[2] * B[0] % mod + A[3] * B[2] % mod) % mod;
        res[3] = (A[2] * B[1] % mod + A[3] * B[3] % mod) % mod;
        return res;
    }
}

//public class D {
//    public static void main(String[] args) throws Exception{
//        java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
//        int T = Integer.parseInt(br.readLine()); // Read the number of test cases
//        for (int i = 0; i < T; i++) {
//            int N = 4;  // given that the matrix is always 2x2, we can set N to 4
//            int[] A = new int[N];
//
//            String[] elems = br.readLine().split(" "); // Read the elements of the array
//            for (int j = 0; j < N; j++) {
//                A[j] = Integer.parseInt(elems[j]); // Parse each element and store it in the array
//            }
//            int X = Integer.parseInt(br.readLine()); // Read the value of X -> exponent
//            matrixMultiplication(A, X);
//        }
//        br.close();
//    }
//
//    static void matrixMultiplication (int[] mat, int x) {
//        long[] temp = new long[4];
//        for (int i = 0; i < 4; i++) {
//            temp[i] = mat[i];
//        }
//        long[] result = new long[4];
//        for (int i = 1; i < x; i++) {
//            result[0] = (temp[0] * mat[0] + temp[1] * mat[2]);
//            result[1] = (temp[0] * mat[1] + temp[1] * mat[3]);
//            result[2] = (temp[2] * mat[0] + temp[3] * mat[2]);
//            result[3] = (temp[2] * mat[1] + temp[3] * mat[3]);
//
//            temp[0] = result[0];
//            temp[1] = result[1];
//            temp[2] = result[2];
//            temp[3] = result[3];
//        }
//        for (int i = 0; i < 4; i++) {
//            result[i] = result[i] % 1000000007;
//        }
//
//        for (int i = 0; i < 3; i+=2) {
//            System.out.println(result[i] + " " + result[i + 1]);
//        }
//    }
//}