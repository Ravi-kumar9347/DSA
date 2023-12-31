
class Solution {
    public static boolean isPossible(int n, int[] coins) {
        boolean[][] dp = new boolean[n][2025];
        for(boolean[] row : dp) Arrays.fill(row, false);
        return fun(0, 0, coins, n, dp);
    }
    
    static boolean fun(int i, int sum, int[] coins, int n, boolean[][] dp){
        if(sum == 2024 || (sum != 0 && (sum % 20 == 0 || sum % 24 == 0))) return true;
        if(i == n) return false;
        if(dp[i][sum] != false) return dp[i][sum];
        
        boolean nottake = fun(i + 1, sum, coins, n, dp);
        boolean take = fun(i + 1, sum + coins[i], coins, n, dp);
        
        return dp[i][sum] = nottake || take;
    }
}
        
