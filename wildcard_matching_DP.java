class Solution {
    public boolean isMatch(String S2, String S1) {
        //O(N*M)
        //S(M)
        int n = S1.length();
		int m = S2.length();

		boolean prev[] = new boolean[m + 1];
		prev[0] = true;

		for (int j = 1; j <= m; j++) {
			prev[j] = false;
		}
		
		for (int i = 1; i <= n; i++) {
			boolean cur[] = new boolean[m + 1];
			cur[0] = isAllStars(S1, i);
			for (int j = 1; j <= m; j++) {

				if (S1.charAt(i - 1) == S2.charAt(j - 1) || S1.charAt(i - 1) == '?')
					cur[j] = prev[j - 1];

				else {
					if (S1.charAt(i - 1) == '*')
						cur[j] = prev[j] || cur[j - 1];

					else
						cur[j] = false;
				}
			}
			prev = cur;
		}

		return prev[m];
    }

    private static boolean isAllStars(String S1, int i) {
		for (int j = 1; j <= i; j++) {
			if (S1.charAt(j - 1) != '*')
				return false;
		}
		return true;
	}
}