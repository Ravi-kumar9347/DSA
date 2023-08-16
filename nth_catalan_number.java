class Solution {
    public static int findCatalan(int n) {
        //O(N*N)
        //S(N)
        int mod = (int)1e9 + 7;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        
        for(int i = 1; i < n + 1; i++){
            for(int j = 0; j < i; j++){
                dp[i] = (dp[i] + (dp[j] * dp[i - j- 1]) % mod) % mod;
            }
        }
        return (int)dp[n];
    }
}
    