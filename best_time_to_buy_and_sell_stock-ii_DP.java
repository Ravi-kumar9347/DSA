class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // int[][] dp = new int[n+1][2];

        // for(int i = n - 1; i >= 0; i--){
        //     for(int buy = 1; buy >= 0; buy--){
        //         int profit = 0;
        //         if(buy == 1){
        //             profit = Math.max(dp[i + 1][buy], dp[i + 1][0] - prices[i]);
        //         } 
        //         else{
        //             profit = Math.max(dp[i + 1][buy], dp[i + 1][1] + prices[i]);           
        //         } 
        //         dp[i][buy] = profit;
        //     }
        // }
        // return dp[0][1];


        //O(N)
        //S(1)
        int b = 0, s = 0;

        for(int i = n - 1; i >= 0; i--){
            b = Math.max(b, s - prices[i]);
            s = Math.max(s, b + prices[i]);           
        }
        return b;
    }

    private static int fun(int i, int buy, int[] prices, int n){
        if(i == n - 1 && buy == 0) return prices[i];
        else if(i == n - 1 && buy == 1) return 0;

        int profit = 0;
        if(buy == 1){
            profit = Math.max(fun(i + 1, buy, prices, n), fun(i + 1, 0, prices, n) - prices[i]);
        } 
        else{
            profit = Math.max(fun(i + 1, buy, prices, n), fun(i + 1, 1, prices, n) + prices[i]);           
        }

        return profit;
    }
}