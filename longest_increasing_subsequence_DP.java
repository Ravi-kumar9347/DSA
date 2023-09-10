class Solution {
    public int lengthOfLIS(int[] nums) {
        //O(N*N)
        //S(N)
        int n = nums.length;
        // int[] prev = new int[n+1];

        // for(int i = n - 1; i >= 0; i--){
        //     int[] cur = new int[n+1];
        //     for(int j = i - 1; j >= -1; j--){
        //         int notTake = prev[j+1];
        //         int take = 0;
        //         if(j == -1 || nums[i] > nums[j]){
        //             take = 1 + prev[i+1];
        //         }
        //         cur[j+1] = Math.max(notTake, take);
        //     }
        //     prev = cur;
        // }
        // return prev[0];

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int ans = 1;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;

    }
}