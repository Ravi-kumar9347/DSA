class Solution {
    public int helper(int index, int prev, int[] arr, int diff) {
        int n = arr.length;
        if (index >= n) {
            return 0;
        }

        int take = 0;
        int notake = 0;
        if (prev == -10000) {
            notake = helper(index + 1, prev, arr, diff);
            take = 1 + helper(index + 1, arr[index], arr, diff);
        } else {
            notake = helper(index + 1, prev, arr, diff);
            if (arr[index] - prev == diff) {
                take = 1 + helper(index + 1, arr[index], arr, diff);
            }
        }
        return Math.max(take, notake);
    }

    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        return helper(0, -10000, arr, difference);

        //Using Map -> O(N) , S(N)
        // int n = arr.length;
        // Map<Integer, Integer> map = new HashMap<>();
        // int maxLength = 1;
        // for(int i = 0; i < n; i++){
        //     int num = arr[i] - difference;
        //     if(map.containsKey(num)){
        //         int curLength = map.get(num) + 1;
        //         map.put(arr[i], curLength);
        //         maxLength = Math.max(maxLength, curLength);
        //     }else{
        //         map.put(arr[i], 1);
        //     }
        // }
        // return maxLength;
    }
}