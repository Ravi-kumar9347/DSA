class Solution {
    public long maxScore(int[] nums, int x) {
        int n = nums.length;
        // long[][] dp = new long[n+1][n+1];
        // for(long[] row : dp){
        //     Arrays.fill(row, -1);
        // }
        // long score = nums[0] + fun(1, 0, nums, n, x, dp);
        // return score;
        
//         long[][] dp = new long[n+1][n+1];
//         for(int ind = n - 1; ind >= 1; ind--){
//             for(int prevInd = ind - 1; prevInd >= 0; prevInd--){
//                 long notTake = dp[ind + 1][prevInd];
        
//                 long take = 0;
//                 if(nums[prevInd] % 2 == nums[ind] % 2){
//                     take = nums[ind] + dp[ind + 1][ind];
//                 }
//                 else{
//                     take = take = nums[ind] - x + dp[ind + 1][ind];
//                 }

//                 dp[ind][prevInd] = Math.max(notTake, take);
//                 System.out.println(Math.max(notTake, take));
//             }
//         }
        
//         return nums[0] + dp[1][0];
        
        //do space optimization ->
    }
    
    long fun(int ind, int prevInd, int[] nums, int n, int x, long[][] dp){
        if(ind == n) return 0;
        if(dp[ind][prevInd] != -1) return dp[ind][prevInd];
        
        long notTake = fun(ind + 1, prevInd, nums, n, x, dp);
        
        long take = 0;
        if(nums[prevInd] % 2 == nums[ind] % 2){
            take = nums[ind] + fun(ind + 1, ind, nums, n, x, dp);
        }
        else{
            take = take = nums[ind] - x + fun(ind + 1, ind, nums, n, x, dp);
        }
        
        return dp[ind][prevInd] = Math.max(notTake, take);
    }
    
}