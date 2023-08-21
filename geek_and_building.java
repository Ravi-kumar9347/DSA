class Solution {
    public static long maximum_energy(int n, int[] heights) {
        // code here
        //O(N)
        //S(N)
        int[] dp = new int[n];
        dp[n-1] = heights[n-1];
        int maxi = dp[n-1];
        for(int i = n -  2; i >= 0; i--){
            int j = i + 1;
            while(j < n && heights[i] > heights[j]){
                j++;
            }
            if(j == n) dp[i] = heights[i];
            else dp[i] = heights[i] ^ dp[j];
            
            maxi = Math.max(maxi, dp[i]);
        }
        return maxi;
    }
}
        
