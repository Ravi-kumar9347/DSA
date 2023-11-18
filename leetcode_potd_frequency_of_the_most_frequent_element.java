class Solution {
    public int maxFrequency(int[] nums, int k) {
        //O(NlogN)
        //S(1)
        int n = nums.length, ans = 0, l = 0;
        long total = k;
        Arrays.sort(nums);
        for(int r = 0; r < n; r++){
            total += nums[r];
            while((long)(nums[r] * (r - l + 1)) > total){
                total -= nums[l];
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}