// class Solution {
//     public String longestPalindrome(String s) {
//         //O(N*N)
//         //S(1)
//         int n = s.length();
//         int maxLen = 0; // Maximum length of the palindromic substring found.
//         int start = 0;  // Starting index of the longest palindromic substring.

//         for (int i = 0; i < n; i++) {
//             // Expand around the center (i) for odd-length palindromes.
//             int len1 = expandAroundCenter(s, i, i);

//             // Expand around the center between (i) and (i + 1) for even-length palindromes.
//             int len2 = expandAroundCenter(s, i, i + 1);

//             int len = Math.max(len1, len2);

//             if (len > maxLen) {
//                 maxLen = len;
//                 start = i - (len - 1) / 2;
//             }
//         }

//         return s.substring(start, start + maxLen);
//     }

//     private int expandAroundCenter(String s, int left, int right) {
//         int n = s.length();
//         while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
//             left--;
//             right++;
//         }
//         return right - left - 1; // Length of the palindromic substring.
//     }
// }


public class Solution {
    public String longestPalindrome(String s) {
        //O(N)
        //S(N)
        //manachers algo ->
        StringBuilder sb = new StringBuilder("^#");
        for (char c : s.toCharArray()) {
            sb.append(c).append("#");
        }
        sb.append("$");
        String T = sb.toString();
        
        int n = T.length();
        int[] P = new int[n];
        int C = 0, R = 0;
        
        for (int i = 1; i < n-1; i++) {
            P[i] = (R > i) ? Math.min(R - i, P[2*C - i]) : 0;
            while (T.charAt(i + 1 + P[i]) == T.charAt(i - 1 - P[i]))
                P[i]++;
            
            if (i + P[i] > R) {
                C = i;
                R = i + P[i];
            }
        }
        
        int max_len = 0, center_index = 0;
        for (int i = 0; i < n; i++) {
            if (P[i] > max_len) {
                max_len = P[i];
                center_index = i;
            }
        }
        return s.substring((center_index - max_len) / 2, (center_index + max_len) / 2);
    }
}