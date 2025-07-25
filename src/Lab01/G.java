package Lab01;

import java.util.Scanner;

public class G {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] id = new int[N];
        int[] marks = new int[N];

        for (int i = 0; i < N; ++i) {
            id[i] = sc.nextInt();
        }

        for (int i = 0; i < N; ++i) {
            marks[i] = sc.nextInt();
        }

        int swapCount = 0;
        for (int i = 0; i < N - 1; ++i) {
            int maxIdx = i;
            for (int j = i + 1; j < N; ++j) {
                if (marks[j] > marks[maxIdx]) {
                    maxIdx = j;
                } else if (marks[j] == marks[maxIdx] && id[j] < id[maxIdx]) {
                    maxIdx = j;
                }
            }
            if (maxIdx != i) {
                swap(marks, i, maxIdx);
                swap(id, i, maxIdx);
                swapCount++;
            }
        }
        System.out.println("Minimum swaps: " + swapCount);
        resultList(id, marks);
        sc.close();
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void resultList(int[] id, int[] marks) {
        for (int i = 0; i < id.length; ++i) {
            System.out.println("ID: " + id[i] + " Mark: " + marks[i]);
        }
    }
}
