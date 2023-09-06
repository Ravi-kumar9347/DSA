class Solution {
    public int minDistance(String s, String t) {
        //O(N*M)
        //S(M)
        int n = s.length();
        int m = t.length();
        int[] prev = new int[m + 1];
        
        for(int i = m; i >= 0; i--) prev[i] = m - i;

        for(int i = n - 1; i >= 0; i--){
            int[] cur = new int[m + 1];
            cur[m] = n - i;
            for(int j = m - 1; j >= 0; j--){
                if(s.charAt(i) == t.charAt(j)) cur[j] = prev[j + 1];
                else cur[j] = 1 + Math.min(cur[j + 1], Math.min(prev[j], prev[j + 1]));
            }
            prev = cur;
        }
        return prev[0];
    }
}

// class Solution {
//     //Memoization -> O(N*M) , S(N*M)+ S(N+M)
//     // private int fun(int i,int j,String s,String t,int[][] dp){
//     //     if(i==0) return j;
//     //     if(j==0) return i;

//     //     if(dp[i][j]!=-1) return dp[i][j];
//     //     if(s.charAt(i-1)==t.charAt(j-1)) return dp[i][j]=fun(i-1,j-1,s,t,dp);
//     //     return dp[i][j]=1 + Math.min(fun(i,j-1,s,t,dp), Math.min(fun(i-1,j,s,t,dp), fun(i-1,j-1,s,t,dp)));
//     // }
//     public int minDistance(String s, String t) {
//         int n = s.length();
//         int m = t.length();
//         //int dp[][] = new int[n+1][m+1];
//         // for(int[] row:dp) Arrays.fill(row,-1);
//         // return fun(n,m,s,t,dp);

//         //Tabularization -->O(N*M) ,S(N*M)
//         // for(int j=0;j<=m;j++) dp[0][j] = j;
//         // for(int i=0;i<=n;i++) dp[i][0] = i;

//         // for(int i=1;i<=n;i++){
//         //     for(int j=1;j<=m;j++){
//         //         if(s.charAt(i-1)==t.charAt(j-1)) dp[i][j]=dp[i-1][j-1];
//         //         else dp[i][j]=1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
//         //     }
//         // }
//         // return dp[n][m];

//         //space optimization --> O(N*M) S(2M)

//         int prev[] = new int[m+1];
//         for(int j=0;j<=m;j++) prev[j] = j;

//         for(int i=1;i<=n;i++){
//             int cur[] = new int[m+1];
//             cur[0] = i;
//             for(int j=1;j<=m;j++){
//                 if(s.charAt(i-1)==t.charAt(j-1)) cur[j]=prev[j-1];
//                 else cur[j]=1 + Math.min(cur[j-1], Math.min(prev[j], prev[j-1]));
//             }
//             prev = cur;
//         }
//         return prev[m];
//     }
// }