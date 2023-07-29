public class Solution {
    private double[][] memo; // To store the calculated probabilities

    public double soupServings(int n) {
        // if (n >= 4000) return 1.0; // The probability approaches 1 when n >= 4800
        // memo = new double[n + 1][n + 1];
        // return dfs(n, n);


        //tabulation ->
        //O(N*N) ~ O(4000)
        //S(N*N) ~ S(4000)
        if (n >= 4000) return 1.0;

        n = (n + 24) / 25; // Normalize the input to reduce array size

        double[][] dp = new double[n + 1][n + 1];
        dp[0][0] = 0.5;

        for (int b = 1; b <= n; b++) {
            dp[0][b] = 1.0;
        }

        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                dp[a][b] = 0.25 * (dp[Math.max(a - 4, 0)][b] + dp[Math.max(a - 3, 0)][Math.max(b - 1, 0)]
                        + dp[Math.max(a - 2, 0)][Math.max(b - 2, 0)] + dp[Math.max(a - 1, 0)][Math.max(b - 3, 0)]);
            }
        }

        return dp[n][n];
    }

    private double dfs(int a, int b) {
        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0) return 1.0;
        if (b <= 0) return 0.0;
        if (memo[a][b] > 0) return memo[a][b];

        double prob = 0.0;
        prob += 0.25 * (dfs(a - 100, b) + dfs(a - 75, b - 25) + dfs(a - 50, b - 50) + dfs(a - 25, b - 75));

        return memo[a][b] = prob;
    }
}
