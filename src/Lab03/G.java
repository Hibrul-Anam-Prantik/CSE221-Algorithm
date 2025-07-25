package Lab03;

import java.io.*;
import java.util.*;

public class G {
    static int[] inorder, preorder;
    static int N;
    static Map<Integer, Integer> inorderIndexMap;
    static StringBuilder sb = new StringBuilder();

    static void buildPostOrder(int inStart, int inEnd, int preStart, int preEnd) {
        if (inStart > inEnd || preStart > preEnd) return;

        int root = preorder[preStart];
        int rootIndex = inorderIndexMap.get(root);
        int leftCount = rootIndex - inStart;

        // Left subtree
        buildPostOrder(inStart, rootIndex - 1, preStart + 1, preStart + leftCount);
        // Right subtree
        buildPostOrder(rootIndex + 1, inEnd, preStart + leftCount + 1, preEnd);
        // Root
        sb.append(root).append(" ");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        inorder = new int[N];
        preorder = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            preorder[i] = Integer.parseInt(st.nextToken());
        }

        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        buildPostOrder(0, N - 1, 0, N - 1);
        System.out.println(sb.toString().trim());
    }
}

