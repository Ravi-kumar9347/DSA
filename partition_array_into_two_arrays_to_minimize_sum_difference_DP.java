class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int num : nums) sum += (num);

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
        
        int i = 0;
        for(i = k; i >= 0; i--){
            if(prev[i] == true) break;
        }

        return Math.abs((sum - i) - i);
    }
}