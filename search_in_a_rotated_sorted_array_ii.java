class Solution {
    public boolean search(int[] nums, int target) {
        //O(NlogN)
        int low=0,high=nums.length-1,mid;
        while(low<=high){
            mid=(low+high)/2;
            if (target==nums[mid]) {
             return true;
            } 

            if (nums[low] == nums[mid]) {
                low++;
                continue;
            }
            
            if(nums[low]<=nums[mid]){
                if(target>nums[mid] ||target<nums[low]){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }else{
                if(target<nums[mid] || target>nums[high]){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }
        }
        return false;
    }
}