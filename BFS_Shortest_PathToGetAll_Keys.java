// class State{
//     int row;
//     int col;
//     Set<Character> keys;
//     State(int row,int col,Set<Character> keys){
//         this.row = row;
//         this.col = col;
//         this.keys = keys;
//     }
// }
class Solution {

    public int shortestPathAllKeys(String[] grid) {
        //O(N * M * 2^K)
        //S(N * M * 2^K)
        // int rows = grid.length;
        // int cols = grid[0].length();
        // int[] dr = {-1,1,0,0};
        // int[] dc = {0,0,-1,1};
        // int numKeys = 0;
        // int startRow = 0;
        // int startCol = 0;

        // for(int r = 0; r < rows; r++){
        //     for(int c =0; c < cols; c++){
        //         if(grid[r].charAt(c) == '@'){
        //             startRow = r;
        //             startCol = c;
        //         }else if(Character.isLowerCase(grid[r].charAt(c))){
        //             numKeys++;
        //         }
        //     }
        // }

        // Set<Character> allKeys = new HashSet<>();
        // Queue<State> queue = new LinkedList<>();
        // Set<State> visited = new HashSet<>();

        // State startState = new State(startRow, startCol, new HashSet<>());
        // queue.offer(startState);
        // visited.add(startState);

        // int steps = 0;
        // while(!queue.isEmpty()){
        //     int size = queue.size();
        //     for(int i = 0; i < size; i++){
        //         State currState = queue.poll();
        //         int currRow = currState.row;
        //         int currCol = currState.col;
        //         Set<Character> currKeys = currState.keys;

        //         if(currKeys.size() == numKeys){
        //             return steps;
        //         }

        //         for(int j = 0; j < 4; j++){
        //             int newRow = currRow + dr[j];
        //             int newCol = currCol + dc[j];

        //             if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow].charAt(newCol) != '#'){
        //                 char cell = grid[newRow].charAt(newCol);

        //                 if(Character.isUpperCase(cell) && !currKeys.contains(Character.toLowerCase(cell))){
        //                     continue;
        //                 }

        //                 Set<Character> newKeys = new HashSet<>(currKeys); 

        //                 if(Character.isLowerCase(cell)){
        //                     newKeys.add(cell);
        //                 }

        //                 State newState = new State(newRow, newCol, newKeys);

        //                 if(!visited.contains(newState)){
        //                     queue.offer(newState);
        //                     visited.add(newState);
        //                 }
        //             }
        //         }
        //     }
        //     steps++;
        // }
        // return -1;

        //better performance ->
        int rows = grid.length;
        int cols = grid[0].length();
        int[] dr = {-1, 1, 0, 0}; // directions: up, down, left, right
        int[] dc = {0, 0, -1, 1};
        int numKeys = 0;
        int startRow = 0;
        int startCol = 0;

        // Find the starting position and count the number of keys
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r].charAt(c) == '@') {
                    startRow = r;
                    startCol = c;
                } else if (Character.isLowerCase(grid[r].charAt(c))) {
                    numKeys++;
                }
            }
        }

        int allKeysMask = (1 << numKeys) - 1; // Bitmask representing all keys obtained
        boolean[][][] visited = new boolean[rows][cols][1 << numKeys];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{startRow, startCol, 0, 0}); // row, col, keysMask, steps
        visited[startRow][startCol][0] = true;

        while (!queue.isEmpty()) {
            int[] currState = queue.poll();
            int currRow = currState[0];
            int currCol = currState[1];
            int keysMask = currState[2];
            int steps = currState[3];

            if (keysMask == allKeysMask) {
                return steps;
            }

            for (int i = 0; i < 4; i++) {
                int newRow = currRow + dr[i];
                int newCol = currCol + dc[i];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols &&
                        grid[newRow].charAt(newCol) != '#') {
                    char cell = grid[newRow].charAt(newCol);

                    if (Character.isUpperCase(cell) && (keysMask & (1 << (Character.toLowerCase(cell) - 'a'))) == 0) {
                        continue; // Key required to unlock the lock is missing
                    }

                    int newKeysMask = keysMask;

                    if (Character.isLowerCase(cell)) {
                        newKeysMask |= (1 << (cell - 'a'));
                    }

                    if (!visited[newRow][newCol][newKeysMask]) {
                        queue.offer(new int[]{newRow, newCol, newKeysMask, steps + 1});
                        visited[newRow][newCol][newKeysMask] = true;
                    }
                }
            }
        }

        return -1; // No solution found
    }
}