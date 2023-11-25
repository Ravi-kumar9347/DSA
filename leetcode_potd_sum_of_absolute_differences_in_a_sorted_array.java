class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        //O(N)
        //S(N)
        // int n = nums.length;
        // int[] left = new int[n];
        // int l = 0;
        // for(int i = n - 1; i >= 0; i--){
        //     left[i] = nums[n-1] - nums[i];
        // }
        // int[] right = new int[n];
        // int r = 0;
        // for(int i = 0; i < n; i++){
        //     right[i] = nums[i] - nums[0];
        //     r += right[i];
        // }

        // int[] result = new int[n];
        // for(int i = 0; i < n; i++){
        //     result[i] = (l - (left[i] * i)) + (r - (right[i] * (n-i)));
        //     l += left[i];
        //     r -= right[i];
        // }

        // return result;

        //O(N)
        //S(1)
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        int left = 0;
        int right = sum;

        int[] r = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            right -= n;

            r[i] = n * i - left + right - n * (nums.length - i - 1);

            left += n;
        }

        return r;
    }
} 