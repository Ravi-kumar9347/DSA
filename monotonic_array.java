class Solution {
    public boolean isMonotonic(int[] nums) {
        //O(N)
        //S(1)
        boolean increasing = true;
        boolean decreasing = true;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i - 1]) decreasing = false;
            if(nums[i] < nums[i - 1]) increasing = false;
            if(!increasing && !decreasing) return false; // if both becomes true to false then return false;
        }
        return true;
    }
}