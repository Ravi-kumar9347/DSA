class Solution {

    private static int max(int[] nums){
        int maxi = -1;
        for(int num : nums){
            maxi = Math.max(maxi, num);
        }
        return maxi;
    }

    private static boolean isValid(long mid, int[] nums, int threshold){
        int th = 0;
        for(int num : nums){
            th += Math.ceil((double) num / (double) mid);
        }
        if(th <= threshold) return true;
        return false;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        //O(N * log(max(nums)))
        //S(1)
        long low = 0, high = max(nums);
        while(low <= high){
            long mid = (low + high) / 2;
            if(isValid(mid, nums, threshold)){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return (int)low;
    }
}