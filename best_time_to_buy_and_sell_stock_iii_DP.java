class Solution {
    public int maxProfit(int[] prices) {
        // return fun(0, 1, prices, prices.length, 2);

        //tabulation -> 
        // int n = prices.length;
        // int[][][] dp = new int[n+1][2][3];

        // for(int i = n - 1; i >= 0; i--){
        //     for(int buy = 1; buy >= 0; buy--){
        //         for(int k = 1; k < 3; k++){
        //             int profit = 0;
        //             if(buy == 1){
        //                 profit = Math.max(dp[i + 1][buy][k], dp[i + 1][0][k] - prices[i]);
        //             } 
        //             else{
        //                 profit = Math.max(dp[i + 1][buy][k], dp[i + 1][1][k-1] + prices[i]);           
        //             } 
        //             dp[i][buy][k] = profit;
        //         }  
        //     }
        // }
        // return dp[0][1][2];

        //space //O(N * 2 * 2)
        //S(2*3)
        int n = prices.length;
        int[][] prev = new int[2][3];

        for(int i = n - 1; i >= 0; i--){
            int[][] cur = new int[2][3];
            for(int buy = 1; buy >= 0; buy--){
                for(int k = 1; k < 3; k++){
                    int profit = 0;
                    if(buy == 1){
                        profit = Math.max(prev[buy][k], prev[0][k] - prices[i]);
                    } 
                    else{
                        profit = Math.max(prev[buy][k], prev[1][k-1] + prices[i]);           
                    } 
                    cur[buy][k] = profit;
                }  
            }
            prev = cur;
        }
        return prev[1][2];

    }

    private static int fun(int i, int buy, int[] prices, int n, int k){
        if(i == n - 1 && buy == 0) return prices[i];
        else if((i == n - 1 && buy == 1) || k == 0) return 0;

        int profit = 0;
        if(buy == 1){
            profit = Math.max(fun(i + 1, buy, prices, n, k), fun(i + 1, 0, prices, n, k - 1) - prices[i]);
        } 
        else{
            profit = Math.max(fun(i + 1, buy, prices, n, k), fun(i + 1, 1, prices, n, k) + prices[i]);           
        }

        return profit;
    }
}