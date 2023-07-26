class Solution {
    private Long[][] dp;
    public long maxScore(int[] nums, int x) {
        //Time complexity: O(n∗2)(Recursion)
        //Space complexity: O(n∗2)(DP) + O(n)(Stack)  
        // int n = nums.length;
        // dp = new Long[n][2];
        // return nums[0] + solve(1, isOdd(nums[0]), n, x, nums);

        //tabularization ->
        //O(N * 2)
        //S(N)
        // dp = new Long[n+1][2];
        // dp[n][0] =(long) 0;
        // dp[n][1] = (long)0;
        // for (int idx = n - 1; idx >= 0; idx--) {
        //     boolean curParity = isOdd(nums[idx]);
        //     for (int prevParity = 0; prevParity <= 1; prevParity++) {
        //         long notPick = dp[idx + 1][prevParity];
        //         long pick = nums[idx] + dp[idx + 1][curParity ? 1 : 0] - ((curParity ? 1 : 0) == prevParity ? 0 : x);
        //         dp[idx][prevParity] = Math.max(pick, notPick);
        //     }
        // }
        
        // return nums[0] + dp[1][isOdd(nums[0]) ? 1 : 0];

        //space optimization ->
        //O(N)
        //S(1)
        long dp[] = new long[] { -x, -x}, n = nums.length;
        dp[nums[0] & 1] = nums[0];
        for (int i = 1; i < n; i++)
            dp[nums[i] & 1] = Math.max(dp[nums[i] & 1], dp[nums[i] & 1 ^ 1] - x) + nums[i];
        return Math.max(dp[0], dp[1]);
    }
    
    private long solve(int idx, boolean prevParity, int n, int x, int[] nums) {
        if(idx == n) return 0;
        if(dp[idx][prevParity ? 1 : 0] != null) return dp[idx][prevParity ? 1 : 0];
        long notPick = solve(idx + 1, prevParity, n, x, nums);
        boolean curParity = isOdd(nums[idx]);
        long pick = nums[idx] + solve(idx + 1, curParity, n, x, nums) - (curParity == prevParity ? 0 : x);
        return dp[idx][prevParity ? 1 : 0] = Math.max(pick, notPick);
    }
    
    private boolean isOdd(int n) {
        return (n & 1) == 1;
    }
}


       