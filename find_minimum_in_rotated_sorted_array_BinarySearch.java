class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1, minValue = Integer.MAX_VALUE;
        //O(logN)
        //S(1)
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[low] <= nums[mid]){
                minValue = Math.min(minValue, nums[low]);
                low = mid + 1;
            }
            else{
                minValue = Math.min(minValue, nums[mid]);
                high = mid - 1;
            }
        }

        return minValue;
    }
}