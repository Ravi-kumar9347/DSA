class Solution {
    private static int mod = (int)1e9+7;
    public int knightDialer(int n) {
        //O(N)
        //S(N)
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(4, 6)),
                new ArrayList<>(Arrays.asList(6, 8)),
                new ArrayList<>(Arrays.asList(7, 9)),
                new ArrayList<>(Arrays.asList(4, 8)),
                new ArrayList<>(Arrays.asList(0, 3, 9)),
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(0, 1, 7)),
                new ArrayList<>(Arrays.asList(2, 6)),
                new ArrayList<>(Arrays.asList(1, 3)),
                new ArrayList<>(Arrays.asList(2, 4))
        ));

        // long[][] dp = new long[n+1][10];
        // for(long[] row : dp){
        //     Arrays.fill(row, (long)-1);
        // }
        // long ans = 0;
        // for(int i = 0; i < 10; i++){
        //     ans = (ans + fun(n-1, i, adj, dp)) % mod;
        // }
        // return (int)ans;


        //O(N)
        //S(N)
        // long[][] dp = new long[n+1][10];
        // for(int col = 0; col < 10; col++) dp[0][col] = (long)1;
        
        // for(int rem = 1; rem < n; rem++){
        //     for(int i = 0; i < 10; i++){
        //         long ans = 0;
        //         for(int it : adj.get(i)){
        //             ans = (ans + dp[rem-1][it]) % mod;
        //         }
        //         dp[rem][i] = ans;
        //     }
        // }
        
        // long ans = 0;
        // for(int i = 0; i < 10; i++){
        //     ans = (ans + dp[n-1][i]) % mod;
        // }
        // return (int)ans;


        //O(N)
        //S(1)
        long[] prev = new long[10];
        for(int col = 0; col < 10; col++) prev[col] = (long)1;
        
        for(int rem = 1; rem < n; rem++){
            long[] cur = new long[10];
            for(int i = 0; i < 10; i++){
                long ans = 0;
                for(int it : adj.get(i)){
                    ans = (ans + prev[it]) % mod;
                }
                cur[i] = ans;
            }
            prev = cur;
        }
        
        long ans = 0;
        for(int i = 0; i < 10; i++){
            ans = (ans + prev[i]) % mod;
        }
        return (int)ans;
    }

    private static long fun(int rem, int curNum, ArrayList<ArrayList<Integer>> adj, long[][] dp){
        if(rem == 0) return 1;
        if(dp[rem][curNum] != -1) return dp[rem][curNum];

        long result = 0;
        for(int it : adj.get(curNum)){
            result = (result + fun(rem-1, it, adj, dp)) % mod;
        }

        return dp[rem][curNum] = result;
    }
}