class Solution {
    public int findPeakElement(int[] nums) {
        //O(logN)
        //S(1)
        int n = nums.length;
        //write these conditions to avoid multiple if else statement in while loop
        if(n == 1) return 0;
        if(nums[0] > nums[1]) return 0;
        if(nums[n - 1] > nums[n - 2]) return n - 1;

        int low = 1, high = n - 2;
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) return mid;
            //if its incresing space , then update low
            if(nums[mid] > nums[mid - 1]) low = mid + 1;
            //else if its decresing space , then update high (for clarity draw graph) 
            //this else is directly for multiple peaks
            else high = mid - 1;
        }

        return -1;
    }
}