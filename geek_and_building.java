
class Solution {
    public static long maximum_energy(int n, int[] heights) {
        // code here
        //O(N)
        //S(N)
        Stack<Integer> s = new Stack<>();
        int[] nextGreaterElement = new int[n];
        Arrays.fill(nextGreaterElement, -1);

        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && heights[s.peek()] < heights[i]) {
                nextGreaterElement[s.pop()] = i;
            }
            s.push(i);
        }

        long[] dp = new long[n];
        long ans = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (nextGreaterElement[i] == -1) {
                dp[i] = heights[i];
            } else {
                long temp = heights[i];
                dp[i] = temp ^ dp[nextGreaterElement[i]];
            }
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}
