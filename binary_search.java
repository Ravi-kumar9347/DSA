class Solution {
    public int search(int[] nums, int target) {
        //O(logN)
        //S(1)
        int l = 0, h = nums.length - 1;
        while(l <= h){
            int mid = (l + h) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] > target) h = mid - 1;
            else l = mid + 1;
        }

        return -1;
    }
}