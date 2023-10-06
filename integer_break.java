class Solution {
    public int integerBreak(int n) {
        
        if (n <= 3) {
            return n - 1; // For n <= 3, maximum product is obtained by breaking it into (n - 1).
        }

        //O(N)
        //S(1)

        // int[] dp = new int[n + 1];
        // dp[2] = 2;
        // dp[3] = 3;

        // for (int i = 4; i <= n; i++) {
        //     dp[i] = Math.max(2 * dp[i - 2], 3 * dp[i - 3]);
        // }

        // return dp[n];

        //O(1)
        //S(1)
        // int result = 1;
        // while (n > 4) {
        //     result *= 3;
        //     n -= 3;
        // }
        // result *= n;
        // return result;

        //O(1)
        //S(1)
        int quotient = n / 3;
        int remainder = n % 3;
        if (remainder == 0) {
            return (int) Math.pow(3, quotient);
        } else if (remainder == 1) {
            return (int) (Math.pow(3, quotient - 1) * 4);
        } else {
            return (int) (Math.pow(3, quotient) * 2);
        }
    }
}
