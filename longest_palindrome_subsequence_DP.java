class Solution {

    private static int longestCommonSubsequence(String s, String t) {
        //O(N*M)
        //S(M)
        int n = s.length();
        int m = t.length();
        int[]prev = new int[m+1];

        for(int i = n - 1; i >= 0; i--){
            int[]cur = new int[m+1];
            for(int j = m - 1; j >= 0; j--){
                int take = 0;
                if(s.charAt(i) == t.charAt(j)) take = 1 + prev[j+1];
                cur[j] = Math.max(cur[j+1], Math.max(prev[j], take));
            }
            prev = cur;
        }
        return prev[0];
    }

    public int longestPalindromeSubseq(String s) {
        StringBuilder srev = new StringBuilder(s);
        String t = srev.reverse().toString();
        
        return longestCommonSubsequence(s, t);
    }
}