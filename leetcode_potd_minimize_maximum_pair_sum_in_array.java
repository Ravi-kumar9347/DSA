class Solution {
    public int minPairSum(int[] nums) {
        //O(nlogn)
        //S(1)
        int n = nums.length;
        Arrays.sort(nums);
        int l = 0, r = n - 1, ans = 0;
        while(l < r){
            ans = Math.max(ans, nums[l] + nums[r]);
            l++;
            r--;
        }
        return ans;
    }
}