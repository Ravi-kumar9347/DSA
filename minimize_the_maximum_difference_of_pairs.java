class Solution {
    //
    private boolean isValid(int minDifference, int p, int[] nums){
        int i = 0;
        while(i < nums.length - 1){
            if(Math.abs(nums[i] - nums[i + 1]) <= minDifference){
                p--;
                i += 2;
            }
            else{
                i += 1;
            }
            if(p == 0) return true;
        }
        return false;
    }
    public int minimizeMax(int[] nums, int p) {
        if(p == 0) return 0;
        //O(NlogN)
        Arrays.sort(nums);
        int low = 0, high = (int)1e9;
        int result = (int)1e9;

        //binary + greedy O(NlogM) M -> search space;
        while(low <= high){
            int mid = (low + high) / 2;
            if(isValid(mid, p, nums)){
                result = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return result;
    }
}