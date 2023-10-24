class Solution{
    
    static boolean isPalindrome(int i, int j, String s){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
    static int solve(int ind, String s, int n, int[] dp){
        if(ind == n) return 0;
        
        if(dp[ind] != -1) return dp[ind];
        
        int minCost = Integer.MAX_VALUE;
        for(int i = ind; i < n; i++){
            if(isPalindrome(ind, i, s)){
                int cost = 1 + solve(i + 1, s, n, dp);
                minCost = Math.min(minCost, cost);
            }
        }
        
        return dp[ind] = minCost;
    }
    
    static int palindromicPartition(String str)
    {
        //O(N*N)
        //S(N*N) + S(n)
        int n = str.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(0, str, n, dp) - 1;
    }
}