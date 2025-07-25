package Lab02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class C {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line01 = br.readLine().split(" ");
        int n = Integer.parseInt(line01[0]); // Size of the array
        int x = Integer.parseInt(line01[1]); // target sum
        Array[] arr = new Array[n]; // Array of size n
        String[] elements = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = new Array(Integer.parseInt(elements[i]), i + 1); // Storing value and 1-based index
        }
        // Sorting the array based on the values | selection sort
        for (int i = 0; i < n - 1; i++) {
            int minI = i;
            for (int j = i + 1; j < n; j++) {
                if(arr[j].value < arr[minI].value) minI = j;
            }
            // Swap the elements
            Array temp = arr[i];
            arr[i] = arr[minI];
            arr[minI] = temp;
        }
        // Searching for the triplet pair with the given sum using two pointer technique
        for (int i = 0; i < n - 2; i++) {
            int start = i + 1, end = n - 1; // Two pointers
            while (start < end) {
                int sum = arr[i].value + arr[start].value + arr[end].value;
                if (sum == x) {
                    System.out.println(arr[i].index + " " + arr[start].index + " " + arr[end].index);
                    return; // Triplet found, exit the program
                } else if (sum < x) {
                    start++; // Move the start pointer to the right to increase the sum
                } else {
                    end--; // Move the end pointer to the left to decrease the sum
                }
            }
        }
        System.out.println(-1); // No triplet found
        br.close();
    }

    // this class saves the value and index of the array elements. so that we can sort the array and still keep track of the original indices.
    static class Array {
        int value, index;

        Array(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
