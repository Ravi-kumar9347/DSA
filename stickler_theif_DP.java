class Solution
{
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
        //O(N)
        //S(N)
        int[] dp = new int[n + 2];
        
        for(int i = n - 1; i >= 0; i--){
            dp[i] = Math.max(dp[i + 1], arr[i] + dp[i + 2]);
        }
        
        return dp[0];
    }
}