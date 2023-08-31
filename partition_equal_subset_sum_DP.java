class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int num : nums) sum += num;

        if(sum % 2 != 0) return false;

        int k = sum / 2;
        //O(N * K)
        //S(K)
        boolean[] prev = new boolean[k+1];
        prev[0] = true;
        
        for(int i = n - 1; i >= 0; i--){
            boolean[] cur = new boolean[k+1];
            for(int j = 0; j <= k; j++){
                boolean notTake = false, take = false;
                notTake = prev[j];
                if(j - nums[i] >= 0 && j - nums[i] <= k){
                    take = prev[j - nums[i]];
                }
                cur[j] = notTake || take;
            }
            prev = cur;
        }
        
        return prev[k];
    }
}