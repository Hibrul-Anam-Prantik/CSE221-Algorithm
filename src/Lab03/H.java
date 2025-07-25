package Lab03;

import java.io.*;
import java.util.*;

public class H {
    static int[] inorder, postorder;
    static int N;
    static Map<Integer, Integer> inorderIndexMap;
    static StringBuilder sb = new StringBuilder();

    static void buildPreOrder(int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) return;

        // Root is last element in postorder segment
        int root = postorder[postEnd];
        sb.append(root).append(" ");

        int rootIndex = inorderIndexMap.get(root);
        int leftCount = rootIndex - inStart;

        // Recur for left subtree
        buildPreOrder(inStart, rootIndex - 1, postStart, postStart + leftCount - 1);
        // Recur for right subtree
        buildPreOrder(rootIndex + 1, inEnd, postStart + leftCount, postEnd - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        inorder = new int[N];
        postorder = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }

        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        buildPreOrder(0, N - 1, 0, N - 1);
        System.out.println(sb.toString().trim());
    }
}

