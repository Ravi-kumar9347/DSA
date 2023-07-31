class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        // for(int[] row : dp) Arrays.fill(row, -1);

        // return fun(0, 0, s1, s2, dp);

        //tabulation -> O(N * M) S( N * M)
        for (int i = n - 1; i >= 0; i--) {
            dp[i][m] = dp[i + 1][m] + s1.charAt(i);
        }
        for (int j = m - 1; j >= 0; j--) {
            dp[n][j] = dp[n][j + 1] + s2.charAt(j);
        }

        for(int i = n - 1; i >= 0; i--){
            for(int j = m - 1; j >= 0; j--){
                int delS1 = s1.charAt(i) + dp[i + 1][j];
                int delS2 = s2.charAt(j) + dp[i][j + 1];
                int equal = Integer.MAX_VALUE;
                if(s1.charAt(i) == s2.charAt(j)){
                    equal = dp[i + 1][j + 1];
                }
                dp[i][j] = Math.min(delS1, Math.min(delS2, equal));
            }
        }
        return dp[0][0];
    }

    private int fun(int i, int j, String s1, String s2, int[][] dp){
        if(i == s1.length()) return remainingSum(j, s2);
        if(j == s2.length()) return remainingSum(i, s1);
        if(dp[i][j] != -1) return dp[i][j];

        int delS1 = s1.charAt(i) + fun(i + 1, j, s1, s2, dp);
        int delS2 = s2.charAt(j) + fun(i, j + 1, s1, s2, dp);
        int equal = Integer.MAX_VALUE;
        if(s1.charAt(i) == s2.charAt(j)){
            equal = fun(i + 1, j + 1, s1, s2, dp);
        }

        return dp[i][j] = Math.min(delS1, Math.min(delS2, equal));
    }

    private int remainingSum(int i, String s){
        int sum = 0;
        while(i < s.length()){
            sum += s.charAt(i);
            i++;
        }
        return sum;
    }
}