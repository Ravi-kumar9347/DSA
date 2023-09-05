class Solution {
    public int numDistinct(String s, String t) {
        //O(N*M)
        //S(M)
        int mod = (int)1e9 + 7;
        int n = s.length();
        int m = t.length();
        int[] prev = new int[m+1];
        prev[m] = 1;

        for(int i = n - 1; i >= 0; i--){
            int[] cur = new int[m+1];
            cur[m] = 1;
            for(int j = m - 1; j >= 0; j--){
                if(s.charAt(i) == t.charAt(j)) cur[j] += (prev[j+1] % mod);
                cur[j] += (prev[j] % mod);
            }
            prev = cur;
        }

        return prev[0];
    }
}

// class Solution {
//     //Memoization ->O(N*M),S(N*M)+S(N+M)
//     // private int fun(int i,int j, String s,String t,int[][] dp){
//     //     if(j==0) return 1;
//     //     if(i==0) return 0;

//     //     if(dp[i][j]!=-1) return dp[i][j];
//     //     if(s.charAt(i-1)==t.charAt(j-1)){
//     //         return dp[i][j]=fun(i-1,j-1,s,t,dp) + fun(i-1,j,s,t,dp);
//     //     }
//     //     return dp[i][j] = fun(i-1,j,s,t,dp);
//     // }
//     public int numDistinct(String s, String t) {
//         int n = s.length();
//         int m = t.length();
//         // int[][] dp = new int[n+1][m+1];
//         // for(int[] row:dp) Arrays.fill(row,-1);
//         // return fun(n,m,s,t,dp);

//         //Tabularization-> O(N*M) S(N*M)
//         // for(int i=0;i<=n;i++) dp[i][0] =1;

//         // for(int i=1;i<=n;i++){
//         //     for(int j=1;j<=m;j++){
//         //         if(s.charAt(i-1)==t.charAt(j-1)){
//         //             dp[i][j]=dp[i-1][j-1] +dp[i-1][j];
//         //         }
//         //         else{
//         //             dp[i][j] = dp[i-1][j];
//         //         }                
//         //     }
//         // }
//         // return dp[n][m];

//         //Two Array space -> O(N*M) S(2M)
//         // int[] prev = new int[m+1];

//         // prev[0]=1;

//         // for(int i=1;i<=n;i++){
//         //     int[] cur = new int[m+1];
//         //     cur[0]=1;
//         //     for(int j=1;j<=m;j++){
//         //         if(s.charAt(i-1)==t.charAt(j-1)){
//         //             cur[j]=prev[j-1] +prev[j];
//         //         }
//         //         else{
//         //             cur[j] = prev[j];
//         //         }                
//         //     }
//         //     prev = cur;
//         // }
//         // return prev[m];

//         //one array space optimization ->

//         int[] prev = new int[m+1];
//         prev[0]=1;

//         for(int i=1;i<=n;i++){
//             for(int j=m;j>=1;j--){
//                 if(s.charAt(i-1)==t.charAt(j-1)){
//                     prev[j]=prev[j-1] +prev[j];
//                 }             
//             }
//         }
//         return prev[m];
//     }
// }