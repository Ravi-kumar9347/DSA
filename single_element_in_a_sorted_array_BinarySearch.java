class Solution {
    public int singleNonDuplicate(int[] nums) {
        //O(NlogN)
        //S(1)
        // try to eliminate last one number of nums on both sides to which reduce the search space , and requied to elliminate unneccesary if else conditions in while loop
        int n = nums.length;
        if(n == 1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[n - 1] != nums[n - 2]) return nums[n - 1];

        int low = 0, high = n - 1;

        while(low <= high){
            int mid = (low + high) / 2;
            //check whether the element does not match on either side of it(thats why we reduce the search space)
            if(nums[mid - 1] != nums[mid] && nums[mid] != nums[mid + 1]) return nums[mid];

            //if we are even index then the element next to it match OR  we are off index then the element before to it match -> we eliminate left search space becuse the elements in left space are pair , else eliminate right search space
            if((mid % 2 == 0 && nums[mid] == nums[mid + 1]) || (mid % 2 == 1 && nums[mid - 1] == nums[mid])){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        return -1;
    }
}