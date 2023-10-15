//tle
// class Solution {
//     public int numWays(int steps, int arrLen) {
//         int[] prev = new int[arrLen + 1];
//         prev[0] = 1;
//         int mod = (int)1e9 + 7;

//         for(int i = 1; i <= steps; i++){
//             int[] cur = new int[arrLen + 1];
//             for(int j = arrLen; j >= 0; j--){
//                 int stay = prev[j], right = 0, left = 0;
//                 if(j + 1 < arrLen) right = prev[j + 1];
//                 if(j - 1 >= 0) left = prev[j - 1];

//                 cur[j] = (((stay + right) % mod) + left) % mod;
//             }
//             prev = cur;
//         }

//         return prev[0];
//     }
// }

//O(steps * maxPos)
//S(min(steps / 2, arrLen - 1))

class Solution {
    public int numWays(int steps, int arrLen) {
        int mod = (int)1e9 + 7;
        int maxPos = Math.min(steps / 2, arrLen - 1);
        int[] dp = new int[maxPos + 1];
        dp[0] = 1;

        for (int i = 1; i <= steps; i++) {
            int[] next = new int[maxPos + 1];
            for (int j = 0; j <= maxPos; j++) {
                next[j] = dp[j];
                if (j > 0) {
                    next[j] = (next[j] + dp[j - 1]) % mod;
                }
                if (j < maxPos) {
                    next[j] = (next[j] + dp[j + 1]) % mod;
                }
            }
            dp = next;
        }

        return dp[0];
    }
}
