class Solution {
    public boolean canJump(int[] nums) {
        //O(N)
        //S(1)
        int n = nums.length;
        int cur = 0;
        for(int i = 0; i < n; i++){
            if(i > cur) return false;
            cur = Math.max(cur, i + nums[i]);
        }

        return true;
    }
}