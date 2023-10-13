class Solution {
    public int minCostClimbingStairs(int[] cost) {
        //O(N)
        //S(1)
        int n = cost.length;
        int prev1 = 0, prev2 = 0;
        for(int i = 0; i < n; i++){
            int cur = Math.min(prev1, prev2) + cost[i];
            prev2 = prev1;
            prev1 = cur;
        }
        return Math.min(prev1, prev2);
    }
}