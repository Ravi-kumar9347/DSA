
class Solution {
    int distinctSubsequences(String s) {
        //O(N)
        //S(26)
        int n = s.length();
        long[] dp = new long[26];
        Arrays.fill(dp, -1);
    
        long ans = 0, diff = 0;
        int mod = (int)(1e9 + 7);
        
        for(int i = 0; i < n; i++){
            int c = s.charAt(i) - 'a';
            if(i == 0){
                ans = 1;
                dp[c] = 1;
                continue;
            }
            
            diff = 1 + ans;
            
            if(dp[c] == -1){
                ans = (ans + diff) % mod;
            }
            else{
                ans = (ans + diff - dp[c]) % mod;
            }
            
            dp[c] = diff;
        }
        
        ans++;
        
        return (int)(ans < 0 ? ans + mod : ans);
    }
}