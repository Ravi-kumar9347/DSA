class Solution {
    static int mod = (int)1e9+7;

    public int numRollsToTarget(int n, int k, int target) {
        //O(N*target*K)
        //S(target) -> space optimizatoin
        int[][] dp = new int[n + 1][target + 1];
        // for(int[] row : dp){
        //     Arrays.fill(row , -1);
        // }

        // return fun(0, n, k, target, dp);

        dp[n][0] = 1;
        for(int i = n - 1; i >= 0; i--){
            for(int t = 0; t <= target; t++){
                int count = 0;
                for(int j = 1; j <= k; j++){
                    if(t - j >= 0) count = (count + dp[i + 1][t - j]) % mod;
                }
                dp[i][t] = count % mod;
            }
        }

        return dp[0][target];
    }

    static int fun(int i, int n, int k, int target, int[][] dp){
        if(i == n){
            if(target == 0) return 1;
            else return 0;
        }
        if(target < 0) return 0;
        if(dp[i][target] != -1) return dp[i][target];

        int count = 0;
        for(int j = 1; j <= k; j++){
            count = (count + fun(i + 1, n, k, target - j, dp)) % mod;
        }

        return dp[i][target] = count % mod;
    }
}