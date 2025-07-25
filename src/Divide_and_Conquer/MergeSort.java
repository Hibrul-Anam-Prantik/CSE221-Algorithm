package Divide_and_Conquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) throws Exception {
        System.out.print("Enter the length of the array: ");
        // int[] arr = new int[Integer.parseInt(new BufferedReader(new
        // InputStreamReader(System.in)).readLine())];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        // int[] arr = new int[Integer.parseInt(br.readLine())];
        int[] arr = new int[length];
        System.out.print("Enter the elements of the array: ");
        String[] elems = br.readLine().split(" ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(elems[i]);
        }
        System.out.println(Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int startingIndex, int endingIndex) {
        if (startingIndex >= endingIndex)
            return; // Base case: if the array has one or no elements, it is already sorted
        int mid = startingIndex + (endingIndex - startingIndex) / 2; // using this to avoid integerOverflow instead of
        // "(startingIndex + endingIndex) / 2"
        mergeSort(arr, startingIndex, mid); // Recursively sort the left half
        mergeSort(arr, mid + 1, endingIndex); // Recursively sort the right half
        // Merge the sorted halves
        merge(arr, startingIndex, mid, endingIndex);
    }

    public static void merge(int[] arr, int startingIndex, int mid, int endingIndex) {
        int left = startingIndex; // index for left sorted part
        int right = mid + 1; // index for right sorted part
        int[] temp = new int[endingIndex - startingIndex + 1]; // temporary array to hold merged result
        int tempIndex = 0; // index for temporary array

        while (left <= mid && right <= endingIndex) {
            if (arr[left] <= arr[right]) {
                temp[tempIndex++] = arr[left++];
            } else {
                temp[tempIndex++] = arr[right++];
            }
        }

        // sort any remaining elements in the left part
        while (left <= mid) {
            temp[tempIndex++] = arr[left++];
        }
        // sort any remaining elements in the right part
        while (right <= endingIndex) {
            temp[tempIndex++] = arr[right++];

        }

        // copy the sorted elements back to the original array
        for (int i = 0, j = startingIndex; i < temp.length; i++, j++) {
            arr[j] = temp[i];
        }
    }
}
