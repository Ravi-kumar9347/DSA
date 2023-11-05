class Solution {
    public int findChampion(int[][] grid) {
        //O(N)
        //S(1)
        int winner = -1, n = grid.length;
        int cnt = 0;
        for(int i = 0; i < n; i++){
            int ones = 0;
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    ones++;
                }
            }
            if(ones >= cnt){
                cnt = ones;
                winner = i;
            }
        }
        return winner;
    }
}