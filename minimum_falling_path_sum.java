class Solution {
    public int minFallingPathSum(int[][] matrix) {
        //O(N*N)
        //S(N)
        int n = matrix.length;  
        int[] prev = new int[n];
        for(int i = 0; i < n; i++) prev[i] = matrix[n-1][i];

        for(int i = n - 2; i >= 0; i--){
            int[] cur = new int[n];
            for(int j = n - 1; j >= 0; j--){
                int ld = (int)1e9, rd = (int)1e9;
                int b = prev[j];
                if(j > 0) ld = prev[j - 1];
                if(j < n - 1) rd = prev[j + 1];

                cur[j] = matrix[i][j] + Math.min(b, Math.min(ld, rd));
            }
            prev = cur;
        }

        int sum = (int)(1e9);
        for(int i = 0; i < n; i++) sum = Math.min(sum, prev[i]);

        return sum;
    }
}

//striver
// class Solution {
//     public int minFallingPathSum(int[][] matrix) {
//         // int n = matrix.length;
//         // int sum = (int)(1e8);
//         // int[][] dp = new int[n][n];
//         // for(int i=0;i<n;i++){
//         //     sum = Math.min(sum,fun(n-1,i,matrix,n,dp));
//         // }
//         // return sum;


//         //Tabularization -->
//         // int n = matrix.length;
//         // int[][] dp = new int[n][n];
//         // for(int i=0;i<n;i++){
//         //     dp[0][i] = matrix[0][i];
//         // }
//         // for(int i=1;i<n;i++){
//         //     for(int j=0;j<n;j++){
//         //         int ld = (int)(1e8),rd = (int)(1e8);

//         //         int v = matrix[i][j] + dp[i-1][j];
//         //         if(j-1>=0) ld = matrix[i][j] + dp[i-1][j-1];
//         //         if(j+1<n) rd = matrix[i][j] +dp[i-1][j+1];

//         //         dp[i][j] = Math.min(v ,Math.min(ld,rd));
//         //     }
//         // }
//         // int sum = dp[n-1][0];
//         // for(int i=1;i<n;i++){
//         //     sum = Math.min(sum ,dp[n-1][i]);
//         // }
//         // return sum;

//         //Space optimization -->

//         int n = matrix.length;
//         int[] prev = new int[n];
//         for(int i=0;i<n;i++){
//             prev[i] = matrix[0][i];
//         }
//         for(int i=1;i<n;i++){
//             int[] cur= new int[n];
//             for(int j=0;j<n;j++){
//                 int ld = (int)(1e8),rd = (int)(1e8);

//                 int v = matrix[i][j] + prev[j];
//                 if(j-1>=0) ld = matrix[i][j] + prev[j-1];
//                 if(j+1<n) rd = matrix[i][j] +prev[j+1];

//                 cur[j] = Math.min(v ,Math.min(ld,rd));
//             }
//             prev = Arrays.copyOf(cur,n);
//         }
//         int sum = prev[0];
//         for(int i=1;i<n;i++){
//             sum = Math.min(sum ,prev[i]);
//         }
//         return sum;
        
//     }

//     //Memoization -->time limit excced
//     // private int fun(int i,int j,int[][] matrix,int n,int[][] dp){
//     //     if(j<0 || j>=n) return (int)(1e8);
//     //     if(i==0) return matrix[0][j];
//     //     if(dp[i][j]!=0) return dp[i][j];
//     //     int v = matrix[i][j] + fun(i-1,j,matrix,n,dp);
//     //     int ld = matrix[i][j] + fun(i-1,j-1,matrix,n,dp);
//     //     int rd = matrix[i][j] + fun(i-1,j+1,matrix,n,dp);

//     //     return dp[i][j]=Math.min(v ,Math.min(ld,rd));
//     // }
// }