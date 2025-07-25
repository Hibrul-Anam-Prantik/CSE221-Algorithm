package Lab03;

public class A {
    static long inversionPair = 0;
    public static void main(String[] args) throws Exception{
        java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        String[] elems = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(elems[i]);
        }
        inversionPair = 0;
        mergeSort(A, 0, N - 1);
        System.out.println(inversionPair);
        print(A);
        br.close();
    }

//    public static int inversionPair(int[] arr) {
//        int count = 0;
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = i + 1; j < arr.length; j++) {
//                if(arr[i] > arr[j]) count++;
//            }
//        }
//        return count;
//    }

    public static void mergeSort(int[] arr, int sI, int eI) {
        if(sI >= eI) return;
        int mI = sI + (eI - sI) / 2;
        mergeSort(arr, sI, mI);
        mergeSort(arr, mI + 1, eI);
        merge(arr, sI, mI, eI);
    }

    public static void merge(int[] arr, int sI, int mI, int eI) {
        int left = sI, right = mI + 1, tempI = 0;
        int[] temp = new int[eI - sI + 1];

        while(left <= mI && right <= eI) {
            if(arr[left] <= arr[right]) temp[tempI++] = arr[left++];
            else {
                temp[tempI++] = arr[right++];
                inversionPair += (mI - left + 1); // count inversions
            }
        }
        while(left <= mI) temp[tempI++] = arr[left++];

        while(right <= eI) temp[tempI++] = arr[right++];

        for (int i = 0; i < temp.length; i++) arr[sI + i] = temp[i];
    }

    public static void print(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

//    public static void print(int[] a) {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < a.length; i++) {
//            sb.append(a[i]);
//            if (i != a.length - 1) sb.append(" ");
//        }
//        System.out.println(sb);
//    }
}