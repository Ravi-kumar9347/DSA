class Solution {
    public long countStrings(String s) {
        //O(N)
        //S(1)
        int n = s.length();
        
        long[] count = new long[26];
        for(int i = 0; i < n; i++){
            count[s.charAt(i) - 97]++;
        }
        
        long ans = 1;
        for(int i = 0; i < 26; i++){
            for(int j = i + 1; j < 26; j++){
                ans += count[i] * count[j];
            }
        }
        
        return ans;
    }
}