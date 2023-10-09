public class Solution {
    public static int count(int nums[], int n, int target) {
        //O(logN)
        //S(1)
        int low = 0, high = nums.length - 1, mid = 0, first = -1, second = -1;
        while (high >= low) {
            mid = (low + (high - low) / 2);
            if (target == nums[mid]) {
                first = mid;
                high = mid - 1;
            } else if (target < nums[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        low = 0;
        high = nums.length - 1;
        
        while (high >= low) {
            mid = (low + (high - low) / 2);
            if (target == nums[mid]) {
                second = mid;
                low = mid + 1;
            } else if (target < nums[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        if(first == -1) return 0;
        return second - first + 1;
    }
}