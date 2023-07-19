class Solution
{
    public int longestPalinSubseq(String s)
    {
        int n = s.length();
        StringBuilder t = new StringBuilder(s);
        t.reverse();
        String reversedString = t.toString();
        //int dp[][] = new int[n + 1][n + 1];
        // for(int[] row : dp){
        //     Arrays.fill(row, -1);
        // }
        
        // return fun(0, 0, s, reversedString, n, dp);
        
        //tabularization ->
        // for(int i = n - 1; i >= 0; i--){
        //     for(int j = n - 1; j >= 0; j--){
        //         int notTake1 = dp[i + 1][j];
        //         int notTake2 = dp[i][j + 1];
        //         int take = 0;
        //         if(s.charAt(i) == t.charAt(j)){
        //             take = 1 + dp[i + 1][j + 1];
        //         }
        //         dp[i][j] = Math.max(take, Math.max(notTake1, notTake2));
        //     }
        // }
        // return dp[0][0];
        
        //space ->
        int prev[] = new int[n + 1];
        for(int i = n - 1; i >= 0; i--){
            int cur[] = new int[n + 1];
            for(int j = n - 1; j >= 0; j--){
                int notTake1 = prev[j];
                int notTake2 = cur[j + 1];
                int take = 0;
                if(s.charAt(i) == t.charAt(j)){
                    take = 1 + prev[j + 1];
                }
                cur[j] = Math.max(take, Math.max(notTake1, notTake2));
            }
            prev = cur;
        }
        return prev[0];
    }
    
    int fun(int i, int j, String s, String t, int n, int[][] dp){
        if(i == n || j == n) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        
        int notTake1 = fun(i + 1, j, s, t, n, dp);
        int notTake2 = fun(i, j + 1, s, t, n, dp);
        int take = 0;
        if(s.charAt(i) == t.charAt(j)){
            take = 1 + fun(i + 1, j + 1, s, t, n, dp);
        }
        
        return dp[i][j] = Math.max(take, Math.max(notTake1, notTake2));
    }
}