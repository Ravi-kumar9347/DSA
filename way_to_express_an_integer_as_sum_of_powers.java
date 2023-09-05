class Solution {
     private static int mod = (int) (1e9 + 7);
    
    public int numberOfWays(int n, int x) {
//         int[][] dp = new int[n + 1][n + 1];
//         for(int [] row : dp){
//             Arrays.fill(row, -1);
//         }
        
//         return fun(n, 1, x, dp);   
        
            
            //tabularization->
//             int[][] dp = new int[n + 1][n + 1];
        
//         // Initialize base cases
//         for (int i = 0; i <= n; i++) {
//             dp[i][n] = 0; // Fill the last column with zeros
//             dp[0][i] = 1; // Fill the first row with ones (only one way to form sum 0)
//         }
        
//         // Tabulation
//         for (int i = n - 1; i >= 1; i--) {
//             for (int j = n - 1; j >= 1; j--) {
//                 int notTake = dp[j][i + 1];
//                 int take = 0;
//                 int val = (int) Math.pow(i, x);
//                 if (val <= j) {
//                     take = dp[j - val][i + 1];
//                 }
//                 dp[j][i] = (notTake + take) % mod;
//             }
//         }
        
//         return dp[n][1];    
   
        
            //space optimization ->
//         int[] dp = new int[n + 1];
//         int mod = (int) (1e9 + 7);

//         dp[0] = 1;
//         for (int i = 1; i <= n; i++) {
//             for (int j = n; j >= 0; j--) {
//                 int val = (int) Math.pow(i, x);
//                 if (j >= val) {
//                     dp[j] = (dp[j] + dp[j - val]) % mod;
//                 }
//             }
//         }

//         return dp[n];
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