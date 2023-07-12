class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
         Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, -1); // Initialize with prefix sum 0 at index -1
        int prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            prefixSum %= k;

            if (prefixSumMap.containsKey(prefixSum)) {
                int prevIndex = prefixSumMap.get(prefixSum);
                if (i - prevIndex >= 2) {
                    return true;
                }
            } else {
                prefixSumMap.put(prefixSum, i);
            }
        }

        return false;
    }
}