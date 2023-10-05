class Solution {
    long substrCount(String s, int k) {
        //O(N)
        //S(1)
        return atmost(s, k) - atmost(s, k - 1);
    }
    
    private static long atmost(String s, int k){
        int n = s.length();
        int[] count = new int[26];
        int left = 0;
        int distinctCount = 0;
        long ans = 0;

        for (int right = 0; right < n; right++) {
            if (count[s.charAt(right) - 'a'] == 0) {
                distinctCount++;
            }
            count[s.charAt(right) - 'a']++;

            while (distinctCount > k) {
                count[s.charAt(left) - 'a']--;
                if (count[s.charAt(left) - 'a'] == 0) {
                    distinctCount--;
                }
                left++;
            }

            ans += (right - left + 1);
        }

        return ans;
    }
}
