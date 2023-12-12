class Solution {
    public int maxProduct(int[] nums) {
        //O(N)
        //S(N)
        int n = nums.length;
        int maxi1 = nums[0], maxi2 = -1;
        for(int i = 1; i < n; i++){
            if(nums[i] >= maxi1){
                maxi2 = maxi1;
                maxi1 = nums[i];
            }
            else if(nums[i] > maxi2){
                maxi2 = nums[i];
            }
        }

        return (maxi1 - 1) * (maxi2 - 1);
    }
}