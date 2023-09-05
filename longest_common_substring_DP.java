public class Solution {
    public static int lcs(String s, String t){
		//O(N*M)
		//S(M)
        int n = s.length();
        int m = t.length();
		int[] prev = new int[m+1];
		int lcs = 0;
		for(int i = n - 1; i >= 0; i--){
			int[] cur = new int[m+1];
			for(int j = m - 1; j >= 0; j--){
				if(s.charAt(i) == t.charAt(j)){
					cur[j] = 1 + prev[j+1];
					lcs = Math.max(lcs, cur[j]);
				} 
			}
			prev = cur;
		}
		
		return lcs;
    }
}