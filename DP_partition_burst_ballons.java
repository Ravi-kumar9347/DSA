class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] ballons = new int[n + 2];
        ballons[0] = 1;
        for(int i = 0; i < n; i++){
            ballons[i + 1] = nums[i];
        }
        ballons[n + 1] = 1;
        int[][] dp = new int[n + 2][n + 2];
        // for(int[] row : dp){
        //     Arrays.fill(row, -1);
        // }

        // return fun(1, n, ballons, dp);

        for(int i = n; i >= 1; i--){
            for(int j = 1; j <= n; j++){
                if(i > j) continue;
                int maxi = Integer.MIN_VALUE;
                for(int ind = i; ind <= j; ind++){
                    int cost = ballons[i-1] * ballons[ind] * ballons[j+1] + dp[i][ind-1] + dp[ind+1][j];
                    maxi = Math.max(maxi, cost);
                }
                dp[i][j] = maxi;
            }
        }
        return dp[1][n];
    }

    int fun(int i, int j, int[] ballons, int[][] dp){
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int maxi = Integer.MIN_VALUE;
        for(int ind = i; ind <= j; ind++){
            int cost = ballons[i-1] * ballons[ind] * ballons[j+1] + fun(i, ind-1, ballons, dp) + fun(ind+1, j, ballons, dp);
            maxi = Math.max(maxi, cost);
        }

        return dp[i][j] = maxi;
    }
}