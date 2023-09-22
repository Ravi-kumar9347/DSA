class Solution {
    public int maxProfit(int K, int[] prices) {
        //O(N*2*K)
        //S(K*2)
        int n = prices.length;
        int[][] prev = new int[2][K + 1];

        for(int i = n - 1; i >= 0; i--){
            int[][] cur = new int[2][K + 1];
            for(int buy = 1; buy >= 0; buy--){
                for(int k = 1; k <= K; k++){
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
        return prev[1][K];
    }
}