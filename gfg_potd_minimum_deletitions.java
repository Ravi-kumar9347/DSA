
class Solution{
    static int minimumNumberOfDeletions(String s) {
        int n = s.length();
        //O(N*N)
        //S(N)
        // if(n == 1) return 0;
        // int[] prev = new int[n];
        // for(int i = n - 1; i >= 0; i--){
        //     int[] cur = new int[n];
        //     for(int j = i; j < n; j++){
        //         int equal = (int)1e9, notTake = (int)1e9;
                
        //         if(j - 1 >= 0) notTake = 1 + cur[j - 1];
        //         if(s.charAt(i) == s.charAt(j) && j - 1 >= 0) equal = prev[j - 1];
                
        //         cur[j] = Math.min(1 + prev[j], Math.min(notTake, equal));
        //     }
        //     prev = cur;
        // }
        // return prev[n - 1];
        
        
        return longestPalindromeSubseq(s);
        
    }

    private static int longestCommonSubsequence(String s, String t) {
        //O(N*N)
        //S(N)
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

    private static int longestPalindromeSubseq(String s) {
        StringBuilder srev = new StringBuilder(s);
        String t = srev.reverse().toString();
        
        return s.length() - longestCommonSubsequence(s, t);
    }
}