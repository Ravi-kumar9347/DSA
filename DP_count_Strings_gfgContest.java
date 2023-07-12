class Solution {
    
    // 0 -> (
    // 1 -> )
    private static int mod = (int)(1e9 + 7);
    private static int fun(int i, int cnt, int lastChar, int consequtive, int k, String s, int n ,int[][][][] dp){
        if(cnt < 0) return 0;
        if(i == n){
            if(cnt == 0) return 1;
            return 0;
        }
        if(dp[i][cnt][lastChar][consequtive] != -1) return dp[i][cnt][lastChar][consequtive];
        
        int ans = 0, currentChar = -1;
        if(s.charAt(i) == '(') currentChar = 0;
        if(s.charAt(i) == ')') currentChar = 1;
        
        if(s.charAt(i) == '('){
            if(lastChar == currentChar && consequtive < k){
                ans += fun(i + 1, cnt + 1, currentChar, consequtive + 1, k, s, n, dp);
            }
            else if(lastChar != currentChar){
                ans += fun(i + 1, cnt + 1, currentChar, 1, k, s, n, dp);
            }
        }
        else if(s.charAt(i) == ')'){
            if(lastChar == currentChar && consequtive < k){
                ans += fun(i + 1, cnt - 1, currentChar, consequtive + 1, k, s, n, dp);
            }
            else if(lastChar != currentChar){
                ans += fun(i + 1, cnt - 1, currentChar, 1, k, s, n, dp);
            }
        }
        else{ // s.charAt(i) == '?'
            currentChar = 0;
            if(lastChar == currentChar && consequtive < k){
                ans += fun(i + 1, cnt + 1, currentChar, consequtive + 1, k, s, n, dp);
            }
            else if(lastChar != currentChar){
                ans += fun(i + 1, cnt + 1, currentChar, 1, k, s, n, dp);
            }
            
            currentChar = 1;
            if(lastChar == currentChar && consequtive < k){
                ans += fun(i + 1, cnt - 1, currentChar, consequtive + 1, k, s, n, dp);
            }
            else if(lastChar != currentChar){
                ans += fun(i + 1, cnt - 1, currentChar, 1, k, s, n, dp);
            }
        }
        
        return dp[i][cnt][lastChar][consequtive] = ans % mod;
    }
    public static int countStrings(int n, String s, int k) {
        //O(N^2 * k)
        //S(N^2 * k)
        int[][][][] dp = new int[n + 1][n + 1][3][k + 1];
        
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y <= k; y++) {
                        dp[i][j][x][y] = -1;
                    }
                }
            }
        }
        
        return fun(0, 0, 2, 0, k, s, n, dp);
    }
}
        
