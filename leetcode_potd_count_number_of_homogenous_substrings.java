class Solution {
    public int countHomogenous(String s) {
        //O(N)
        //S(1)
        int ans = 0, i = 0, n = s.length(), mod = (int)1e9+7;
        while(i < n){
            int val = 1, streak = 1;
            while(i + 1 < n && s.charAt(i) == s.charAt(i+1)){
                streak++;
                val = (val + streak) % mod;
                i++;
            }
            ans = (ans + val) % mod;
            i++;
        }
        return ans;
    }
}