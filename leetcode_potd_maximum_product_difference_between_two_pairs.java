class Solution {
    public int maxProductDifference(int[] nums) {
        //O(N)
        //S(1)
        int firstlarge = nums[0], secondlarge = -1;
        int firstsmall = nums[0], secondsmall = (int)1e9;
        for(int i = 1; i < nums.length; i++){
            if(firstlarge <= nums[i]){
                secondlarge = firstlarge;
                firstlarge = nums[i];
            }
            else if(secondlarge < nums[i]){
                secondlarge = nums[i];
            }

            if(firstsmall >= nums[i]){
                secondsmall = firstsmall;
                firstsmall = nums[i];
            }
            else if(secondsmall > nums[i]){
                secondsmall = nums[i];
            }
        }

        return (firstlarge * secondlarge) - (firstsmall * secondsmall);
    }
}