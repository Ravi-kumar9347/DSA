class Solution {
    public boolean search(int[] nums, int target) {
        //O(logN)
        //S(1)
        int low=0,high=nums.length-1;
        while(low <= high){
            int mid=(low + high) / 2;
            if (target == nums[mid]) return true;
            //this is an edge case when it has dupllicates shrink search space
            if(nums[low] == nums[mid] && nums[mid] == nums[high]){
                low = low + 1;
                high = high - 1;
                continue;
            }
            //**first find which portion is sorted and then check if target lies in that portion or not
            //left is sorted
            if(nums[low] <= nums[mid]){
                //check if target lies in that left portion or not
                if(nums[low] <= target && target <= nums[mid]){
                    //eliminate right portion
                    high = mid - 1;
                }
                else{
                    //eliminate left portion
                    low = mid + 1;
                }
            }
            else{
                //then right portion is sorted
                if(nums[mid] <= target && target <= nums[high]){
                    //eliminate left portion
                    low = mid + 1;
                }
                else{
                    //eliminate right portion
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}