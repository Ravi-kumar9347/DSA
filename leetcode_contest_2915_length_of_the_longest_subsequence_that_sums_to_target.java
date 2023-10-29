class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int t) {
        //O(N*T)
        //S(T)
        int n = nums.size();
        // int[][] dp = new int[n+1][t+1];
        // // for(int[] row : dp) Arrays.fill(row, -1);
        // // int ans = fun(0, 0, target, nums, dp);
        // // return ans < 0 ? -1 : ans;
        // for(int i = 0; i <= t; i++) dp[n][i] = -1 * (int)1e8;
        // dp[n][t] = 0;
        // for(int i = n - 1; i >= 0; i--){
        //     for(int s = t; s >= 0; s--){
        //         int notTake = dp[i+1][s];
        //         int take = -1 * (int)1e8;
        //         if(s + nums.get(i) <= t) take = 1 + dp[i+1][s+nums.get(i)];
        //         dp[i][s] = Math.max(notTake, take);
        //     }
        // }
        // return dp[0][0] < 0 ? -1 : dp[0][0];
        
        int[]prev = new int[t+1];
        for(int i = 0; i <= t; i++) prev[i] = -1 * (int)1e8;
        prev[t] = 0;
        for(int i = n - 1; i >= 0; i--){
            int[]cur = new int[t+1];
            for(int s = t; s >= 0; s--){
                int notTake = prev[s];
                int take = -1 * (int)1e8;
                if(s + nums.get(i) <= t) take = 1 + prev[s+nums.get(i)];
                cur[s] = Math.max(notTake, take);
            }
            prev = cur;
        }
        return prev[0] < 0 ? -1 : prev[0];
    }
    
    static int fun(int i, int s, int t, List<Integer> n, int[][] dp){
        if(s == t) return 0;
        if(i == n.size()) return -1 * (int)1e8;
        if(dp[i][s] != -1) return dp[i][s];
        int notTake = fun(i+1, s, t, n, dp);
        int take = -1 * (int)1e8;
        if(s + n.get(i) <= t) take = 1 + fun(i+1, s + n.get(i), t, n, dp);
        
        return dp[i][s] = Math.max(notTake, take);
    }
}