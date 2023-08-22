class Solution {
    public int minimumOperations(List<Integer> nums) {
        return nums.size() - longestSubsequence(nums.size(), nums);
    }

    private static int longestSubsequence(int n, List<Integer> arr){
        //O(NlogN)
        //S(N)
        int[] temp = new int[n];
        int len = 1;
        temp[0] = arr.get(0);

        for (int i = 1; i < n; i++) {
            if (arr.get(i) >= temp[len - 1]) {
                temp[len] = arr.get(i);
                len++;
            } else {
                // Binary search for the lower bound index
                int low = 0, high = len - 1;
                int ind = -1;
                
                while (low <= high) {
                    int mid = low + (high - low) / 2;
                    if (temp[mid] > arr.get(i)) {
                        ind = mid;
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
                
                if (ind != -1) {
                    temp[ind] = arr.get(i);
                }
            }
        }
        return len;
    }
}