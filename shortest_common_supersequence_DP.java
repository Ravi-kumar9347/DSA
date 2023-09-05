// class Solution {

//     private static String findLCS(int n, int m, String s, String t){
//         //O(N*M)
//         //S(N*M)
//         int[][] dp = new int[n+1][m+1];

//         for(int i = n - 1; i >= 0; i--){
//             for(int j = m - 1; j >= 0; j--){
//                 int take = 0;
//                 if(s.charAt(i) == t.charAt(j)) take = 1 + dp[i+1][j+1];
//                 dp[i][j] = Math.max(dp[i][j+1], Math.max(dp[i+1][j], take));
//             }
//         }

//         StringBuilder lms = new StringBuilder();
//         int i = 0, j = 0;
//         while(i < n && j< m){
//             if(dp[i][j] == dp[i+1][j]){
//                 i++;
//             }
//             else if(dp[i][j] == dp[i][j+1]){
//                 j++;
//             }else if(dp[i][j] == 1 + dp[i+1][j+1]){
//                 lms.append(s.charAt(i));
//                 i++;
//                 j++;
//             }
//         }
//         return lms.toString();
//     }

//     public String shortestCommonSupersequence(String s, String t) {
//         int n = s.length();
//         int m = t.length();

//         String lcs = findLCS(n, m, s, t);

//         int i = 0, j = 0, k = 0;
//         StringBuilder scs = new StringBuilder();

//         while(i < n && j < m && k < lcs.length()){
//             if(s.charAt(i) == lcs.charAt(k) && t.charAt(j) == lcs.charAt(k)){
//                 scs.append(lcs.charAt(k));
//                 i++;
//                 j++;
//                 k++;
//                 continue;
//             }
//             if(s.charAt(i) != lcs.charAt(k)){
//                 scs.append(s.charAt(i));
//                 i++;
//             }
//             if(t.charAt(j) != lcs.charAt(k)){
//                 scs.append(t.charAt(j));
//                 j++;
//             }
//         }

//         while(i < n){
//             scs.append(s.charAt(i));
//             i++;
//         }

//         while(j < m){
//             scs.append(t.charAt(j));
//             j++;
//         }

//         return scs.toString();
//     }
// }

class Solution {
    public String shortestCommonSupersequence(String s, String t) {
        int n = s.length();
		int m = t.length();

		int dp[][]=new int[n+1][m+1];

		for(int i=1;i<=n;i++){
			for(int j=1;j<=m;j++){
				if(s.charAt(i-1) == t.charAt(j-1)){
					dp[i][j] = 1 +dp[i-1][j-1]; 
				}
				else dp[i][j] = 0 + Math.max(dp[i-1][j],dp[i][j-1]);
			}
		}
		
        int i=n,j=m;
        int len = dp[n][m];

        int ind = len-1;
        String ans ="";
        while(i>0 && j>0){
            if(s.charAt(i-1) == t.charAt(j-1)){
                ans += s.charAt(i-1);
                ind--;
                i--;
                j--;
            }else if(dp[i-1][j] > dp[i][j-1]){
                ans += s.charAt(i-1);
                i--;
            }else{
                ans += t.charAt(j-1);
                j--;
            }
        }

        while(i>0){
            ans += s.charAt(i-1);
            i--;
        }

        while(j>0){
            ans += t.charAt(j-1);
            j--;
        }

        String ans2 = new StringBuilder(ans).reverse().toString();
        return ans2;
    }
}