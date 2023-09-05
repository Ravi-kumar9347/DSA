public class Solution {
    public static String findLCS(int n, int m, String s, String t){
        //O(N*M)
        //S(N*M)
        int[][] dp = new int[n+1][m+1];

        for(int i = n - 1; i >= 0; i--){
            for(int j = m - 1; j >= 0; j--){
                int take = 0;
                if(s.charAt(i) == t.charAt(j)) take = 1 + dp[i+1][j+1];
                dp[i][j] = Math.max(dp[i][j+1], Math.max(dp[i+1][j], take));
            }
        }

        StringBuilder lms = new StringBuilder();
        int i = 0, j = 0;
        while(i < n && j< m){
            if(dp[i][j] == dp[i+1][j]){
                i++;
            }
            else if(dp[i][j] == dp[i][j+1]){
                j++;
            }else if(dp[i][j] == 1 + dp[i+1][j+1]){
                lms.append(s.charAt(i));
                i++;
                j++;
            }
        }
        return lms.toString();
    }
}