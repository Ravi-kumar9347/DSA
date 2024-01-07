
class Solution {
    static int splitArray(int[] nums , int n, int k) {
        //O(N * log(low - sum));
        //S(1)
        int low = -1, high = 0;
        
        for(int num : nums){
            low = Math.max(low, num);
            high += num;
        }

        while(low <= high){
            int mid = (low + high) / 2;
            if(split(mid, nums) <= k){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return low;
    }
    
    private static int split(int largestSum, int[] nums){
        int count = 0, currentSum = 0;
        for(int i = 0; i < nums.length; i++){
            if(currentSum + nums[i] <= largestSum){
                currentSum += nums[i];
            }
            else{
                count++;
                currentSum = nums[i];
            }
        }
        count++;
        return count;
    }
};
