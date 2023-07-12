class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        //O(2N)
        int n = nums.length;
        int count = 0;
        int left = 0, right = 0;

        int noOfKeys = 0;
        while (right < n) {
            if (nums[right] % 2 == 1) {
                noOfKeys++;
            }

            while (left < right && noOfKeys > k) {
                if (nums[left] % 2 == 1) {
                    noOfKeys--;
                }
                left++;
            }

            if (noOfKeys == k) {
                count++;
                int temp = left;
                while (left < right && nums[left] % 2 == 0) {
                    count++;
                    left++;
                }
                left = temp;
            }

            right++;
        }

        return count;
    }
}