class Solution {
    public int maxProfit(int[] prices, int fee) {
        //O(N)
        //S(1)
        int n = prices.length;
        int b = 0, s = 0;

        for(int i = n - 1; i >= 0; i--){
            b = Math.max(b, s - prices[i]);
            s = Math.max(s, b + prices[i] - fee);           
        }
        return b;
    }
}