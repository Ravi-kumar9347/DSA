class Solution {
    public int minPathSum(int[][] grid) {
        //O(M*N)
        //S(N)
        int m = grid.length;   
        int n = grid[0].length;
        int[] prev = new int[n + 1];
        Arrays.fill(prev, (int)1e8);

        for(int i = m - 1; i >= 0; i--){
            int[] cur = new int[n + 1];
            cur[n] = (int)1e8;
            for(int j = n - 1; j >= 0; j--){
                if(i == m - 1 && j == n - 1){
                    cur[j] = grid[i][j];
                    continue;
                }

                cur[j] = grid[i][j] + Math.min(prev[j], cur[j + 1]);
            }
            prev = cur;
        }

        return prev[0];
    }
}