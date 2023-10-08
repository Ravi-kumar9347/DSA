// class Solution {
//     public int maxDotProduct(int[] nums1, int[] nums2) {
//         int n = nums1.length;
//         int m = nums2.length;
        
//         int[] prev = new int[m + 1];
//         for(int i = n - 1; i >= 0; i--){
//             int[] cur = new int[m + 1];
//             for(int j = m - 1; j >= 0; j--){
//                 cur[j] = Math.max(prev[j], Math.max(cur[j + 1], nums1[i] * nums2[j] + prev[j + 1]));
//             }
//             prev = cur;
//         }

//         return prev[0];
//     }
// }

class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        //O(N*M)
        //S(N*M)
        int n = nums1.length;
        int m = nums2.length;

        int[][] dp = new int[n][m];

        dp[0][0] = nums1[0] * nums2[0];
        int maxVal = dp[0][0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(nums1[i] * nums2[0], dp[i - 1][0]);
            maxVal = Math.max(maxVal, dp[i][0]);
        }

        for (int j = 1; j < m; j++) {
            dp[0][j] = Math.max(nums1[0] * nums2[j], dp[0][j - 1]);
            maxVal = Math.max(maxVal, dp[0][j]);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.max(nums1[i] * nums2[j], Math.max(dp[i - 1][j - 1] + nums1[i] * nums2[j], Math.max(dp[i - 1][j], dp[i][j - 1])));
                maxVal = Math.max(maxVal, dp[i][j]);
            }
        }

        return maxVal;
    }
}
