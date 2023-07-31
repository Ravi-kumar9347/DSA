class Solution {
    private int fun(int i, int j, String s, int[][] dp){
        if(i == j) return 1;
        if(dp[i][j] != -1) return dp[i][j];

        int minTurns = Integer.MAX_VALUE;
        for(int k = i; k < j; k++){
            minTurns = Math.min(minTurns, fun(i, k, s, dp) + fun(k + 1, j, s, dp));
        }

        return dp[i][j] = s.charAt(i) == s.charAt(j) ? minTurns - 1 : minTurns;
    }
    public int strangePrinter(String s) {
        // int n = s.length();
        // int[][] dp = new int[n + 1][n + 1];
        // for(int[] row : dp) Arrays.fill(row, -1);
        // return fun(0, n - 1, s, dp);
        
        //tabulation ->
        //O(N * N * N)
        //S(N * N)
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                int ans = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    ans = Math.min(ans, dp[i][k] + dp[k + 1][j]);
                }
                if (s.charAt(i) == s.charAt(j)) ans--;
                dp[i][j] = ans;
            }
        }
        return dp[0][n - 1];
    }
}

