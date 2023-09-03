class Solution {
    public int change(int sum, int[] coins) {
        //O(sum * N)
        //S(sum)
        int[] prev = new int[sum + 1];
        
        for(int i = 0; i < coins.length; i++){
            int[] cur = new int[sum + 1];
            cur[0] = 1;
            for(int s = 1; s < sum + 1; s++){
                int notTake = 0;
                if(i > 0) notTake = prev[s];
                int take = 0;
                if(s - coins[i] >= 0) take = cur[s - coins[i]];
                cur[s] = notTake + take;
            }
            prev = cur;
        }
        
        return prev[sum];
    }
}