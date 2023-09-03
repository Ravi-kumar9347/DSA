class Solution {
    public int coinChange(int[] coins, int amount) {
        //O(N*Amount)
        //S(amount)
        int[] prev = new int[amount+1];
        Arrays.fill(prev, (int)(1e9));
        prev[amount] = 0;

        for(int i = coins.length - 1; i >= 0; i--){
            int[] cur = new int[amount+1];
            for(int j = amount; j >= 0; j--){
                int notTake = prev[j];
                int take = (int)(1e9);
                if(j + coins[i] >= 0 && j + coins[i] <= amount){
                    take = 1 + cur[j + coins[i]];
                }
                cur[j] = Math.min(notTake, take);
            }
            prev = cur;
        }
        return prev[0] == (int)(1e9) ? -1 : prev[0];
    }
}

// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         int[] dp = new int[amount + 1];
//         Arrays.fill(dp, Integer.MAX_VALUE - 1);
//         dp[0] = 0;

//         for (int coin : coins) {
//             for (int j = coin; j <= amount; j++) {
//                 dp[j] = Math.min(dp[j], dp[j - coin] + 1);
//             }
//         }

//         return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];
//     }
// }
