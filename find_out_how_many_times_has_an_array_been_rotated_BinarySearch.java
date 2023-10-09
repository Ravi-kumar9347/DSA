public class Solution {
    public static int findKRotation(int []nums){
        int n = nums.length;
        int low = 0, high = n - 1, minValue = Integer.MAX_VALUE, minIndex = -1;
        //O(logN)
        //S(1)
        while(low <= high){

            if (nums[low] <= nums[high]) {
                if(minValue > nums[low]){
                    minValue = nums[low];
                    minIndex = low;
                }
                break;
            }

            int mid = (low + high) / 2;
            if(nums[low] <= nums[mid]){
                if(minValue > nums[low]){
                    minValue = nums[low];
                    minIndex = low;
                }
                low = mid + 1;
            }
            else{
                if(minValue > nums[mid]){
                    minValue = nums[mid];
                    minIndex = mid;
                }
                high = mid - 1;
            }
        }
        
        return minIndex % n;
    }
}