class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // int[][] dp = new int[n+2][2];

        // for(int i = n - 1; i >= 0; i--){
        //     for(int b = 1; b >= 0; b--){
        //         int profit = 0;
        //         if(b == 1){
        //             profit = Math.max(dp[i+1][b], dp[i+1][0] - prices[i]);
        //         }
        //         else{
        //             profit = Math.max(dp[i+1][b], dp[i+2][1] + prices[i]);
        //         }
        //         dp[i][b] = profit; 
        //     }
        // }
        // return dp[0][1];


        //tabulation
        //O(N)
        //S(1)
        int[] prev1 = new int[2];
        int[] prev2 = new int[2];

        for(int i = n - 1; i >= 0; i--){
            int[] cur = new int[2];
            cur[1] = Math.max(prev1[1], prev1[0] - prices[i]);
            cur[0] = Math.max(prev1[0], prev2[1] + prices[i]); 
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1[1];
    }
}