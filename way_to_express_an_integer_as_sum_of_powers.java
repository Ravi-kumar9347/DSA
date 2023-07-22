class Solution {
    private static int mod = (int)(1e9 + 7);
    
    public int numberOfWays(int n, int x) {
        int[][] dp = new int[n + 1][n + 1];
         for(int [] row : dp){
             Arrays.fill(row, -1);
        }
        

        
        return fun(n, 1, x, dp);   
    }
    
    private int fun(int n, int i, int x, int[][]dp){
        if(n == 0) return 1;
        else if(Math.pow(i, x) > n) return 0;
        if(dp[n][i] != -1) return dp[n][i];
        
        int notTake = fun(n, i + 1, x, dp);
        int take = 0;
        int val = (int)Math.pow(i, x);
        if(val <= n){
            take = fun(n - val, i + 1, x, dp);
        }
        
        return dp[n][i] = (notTake + take) % mod;
    }
    
}