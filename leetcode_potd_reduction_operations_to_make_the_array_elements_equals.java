class Solution {
    public int reductionOperations(int[] nums) {
        //O(NlogN)
        //S(1)
        // Arrays.sort(nums);
        // int ans = 0, cur = 0;
        // for(int i = 1; i < nums.length; i++){
        //     if(nums[i-1] != nums[i]){
        //         cur++;
        //     }
        //     ans += cur;
        // }
        // return ans;

        //O(N) + O(50000)
        //S(50000)
        int n = nums.length;
        int[] freq = new int[50001];
        for (int i = 0; i < n; i++) {
            freq[nums[i]]++;
        }
        int res = 0, operations = 0;
        for (int i = 50000; i >= 1; i--) {
            if (freq[i] > 0) {
                operations += freq[i];
                res += operations - freq[i];
            }
        }
        return res;
    }
}