class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //O(M*N)
        //S(M*N)
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        for(int i = n - 1; i >= 0; i--){
            if(obstacleGrid[m - 1][i] == 1) break;
            dp[m - 1][i] = 1;
        }

        for(int j = m - 1; j >= 0; j--){
            if(obstacleGrid[j][n - 1] == 1) break;
            dp[j][n - 1] = 1;
        }

        for(int i = m - 2; i >= 0; i--){
            for(int j = n - 2; j >= 0; j--){
                if(obstacleGrid[i][j] != 1){
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }
        return dp[0][0];
    }
}