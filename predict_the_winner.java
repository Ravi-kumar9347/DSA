class Solution {
    public boolean PredictTheWinner(int[] nums) {
        //O(N*N)
        //S(N*N)
        int n = nums.length;
        int[][][] dp = new int[n + 1][n + 1][2];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j][0] = -1;
                dp[i][j][1] = -1;
            }
        }
        return fun(0, n - 1, true, nums, dp) >= 0; // Changed condition to check if score1 >= score2
        
    }

    private int fun(int i, int n, boolean isPlayer1, int[] nums, int[][][] dp) {
        if (i > n) return 0;
        if(dp[i][n][isPlayer1 ? 1 : 0] != -1) return dp[i][n][isPlayer1 ? 1 : 0];

        int takeFirst = nums[i] - fun(i + 1, n, !isPlayer1, nums, dp); // Changed addition to subtraction
        int takeLast = nums[n] - fun(i, n - 1, !isPlayer1, nums, dp); // Changed addition to subtraction
        int score1 = 0, score2 = 0;
        if (isPlayer1) {
            score1 = Math.max(takeFirst, takeLast);
        } else {
            score2 = Math.max(takeFirst, takeLast);
        }

        return dp[i][n][isPlayer1 ? 1 : 0] = isPlayer1 ? score1 : score2; // Return the score without comparing
    }
}
