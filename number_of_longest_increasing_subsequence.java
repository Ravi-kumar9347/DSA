class Solution {
    private int count = 0;

    public int findNumberOfLIS(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        int[] c = new int[n];
        for(int i = 0; i < n; i++){
            c[i] = 1;
        }
        int maxi = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i] && 1 + dp[j] > dp[i]){
                    dp[i] = 1 + dp[j];
                    c[i] = c[j];
                }
                else if(arr[j] < arr[i] && 1 + dp[j] == dp[i]){
                    c[i] += c[j];
                }          
            }
            maxi = Math.max(maxi, dp[i]);
        }
        int nof = 0;
        for(int i = 0; i < n; i++){
            if(dp[i] == maxi) nof += c[i];
        }
        return nof;
    }

    
}
