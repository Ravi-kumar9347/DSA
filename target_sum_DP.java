class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        //O(N * 2 * sum)
        //S(2 * sum)
        int sum = 0;
        for(int i : nums) sum += i;

        if((-1 * sum) > target || sum < target) return 0;

        int n = 2 * sum + 1;
        int[] prev = new int[n];
        prev[sum + target] = 1;

        int result = 0;

        for(int i = nums.length - 1; i >= 0; i--){
            int[] cur = new int[n];
            for(int j = n - 1 ; j >= 0; j--){
                int minus = 0, plus = 0;
                if(j - nums[i] >= 0) minus = prev[j - nums[i]];
                if(j + nums[i] < n) plus = prev[j + nums[i]];
                cur[j] =  minus + plus;
            }
            prev = cur;
        }
        return prev[sum];
    }
} 