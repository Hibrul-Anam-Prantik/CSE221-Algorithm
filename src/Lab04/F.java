public class F {
    public static void main(String[] args) throws Exception {
        java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int x = Integer.parseInt(input[0]), y = Integer.parseInt(input[1]);

        // using the grid/matrix convention: (x, y) = (row, col) --> 
        // row + 1 = down, col + 1 = right, // row - 1 = up, col - 1 = left
        // 1-based indexing for the grid

        // 8 possible directions --> 
        // Up, Down, Left, Right, up-left, up-right, down-left, down-right
        /*
        Moves :  Up,  Down, Left, Right, UpLeft, UpRight, DownLeft, DownRight
        dRow  :  -1,    1,    0,    0,    -1,     -1,       1,         1
        dCol  :   0,    0,   -1,    1,    -1,      1,      -1,         1
         */
        int[] dRow = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] dCol = {0, 0, -1, 1, -1, 1, -1, 1};
        
        /*
         *  The king moves to a new position (nx, ny) & is valid only if:
            *    1 ≤ newX ≤ N and
            *    1 ≤ newY ≤ N
        */
        // storing the valid positions in a List
        java.util.ArrayList<int[]> validPositions = new java.util.ArrayList<>();

        for(int i = 0; i < 8; ++i) {
            // Calc new position
            int newX = x + dRow[i];  
            int newY = y + dCol[i]; 
            // checking if the new position is valid & within bounds
            if(0 < newX && newX <= N && 0 < newY && newY <= N) {
                // Valid position, add to the list --> an array of size 2 ; (x, y)
                // where x = newX, y = newY
                // representing the new position (newX, newY)
                validPositions.add(new int[]{newX, newY});
            }
        }
        // sorting the valid positions based on the first element (row) and then by the second element (column)
        validPositions.sort((a, b) -> {
            if(a[0] != b[0]) return a[0] - b[0]; // sort by row 
            return a[1] - b[1]; // sort by column if rows are equal
        });

        // Printing the valid positions
        StringBuilder sb = new StringBuilder();
        for(int[] move : validPositions) {
            sb.append(move[0]).append(" ").append(move[1]).append("\n");
        }
        System.out.println(validPositions.size());
        System.out.println(sb.toString().trim());
        br.close();
    }
}
