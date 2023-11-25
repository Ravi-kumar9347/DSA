class Solution {
    public int minimumCoins(int[] prices) {
        //O(N*N)
        //S(N*N)
        int n = prices.length;
        int[][] dp = new int[n+1][n+1];
        for(int[] row : dp) Arrays.fill(row, -1);
        return fun(0, 0, n, prices, dp);
    }
    
    private static int fun(int i, int free, int n, int[] prices, int[][] dp){
        if(i == n) return 0;
        if(dp[i][free] != -1) return dp[i][free];
        int notFree = Integer.MAX_VALUE, takeAgain = Integer.MAX_VALUE;
        notFree = prices[i] + fun(i+1, i+1, n, prices, dp);
        if(free > 0){
            takeAgain = fun(i+1, free-1, n, prices, dp);
        }
        
        return dp[i][free] = Math.min(notFree, takeAgain);
    }
}