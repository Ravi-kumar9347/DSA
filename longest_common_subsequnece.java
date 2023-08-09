class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String s1, String s2)
    {
        //O(N*M)
        //S(M)
        int n = s1.length();
        int m = s2.length();
        int[] prev = new int[m + 1];
        
        for(int i = n - 1; i >= 0; i--){
            int[] cur = new int[m + 1];
            for(int j = m - 1; j >= 0; j--){
                int notTake1 = prev[j];
                int notTake2 = cur[j + 1];
                int take = 0;
                if(s1.charAt(i) == s2.charAt(j)) take = 1 + prev[j + 1];
                
                cur[j] = Math.max(notTake1, Math.max(notTake2, take));
            }
            prev = cur;
        }
        
        return prev[0];
    }
    
}