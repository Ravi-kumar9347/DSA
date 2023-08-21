// class Solution {
//     public boolean canMakeSubsequence(String str1, String str2) {
//         int n = str1.length();
//         int m = str2.length();
//         int i = 0, j = 0;
//         while(i < n && j < m){
//             int s1 = (int)str1.charAt(i);
//             int s2 = (int)str2.charAt(j);
//             int s12 = s1 + 1;
//             if(s1 + 1 > 122) s12 = 97;

//             if(s1 == s2 || s12 == s2){
//                 i++;
//                 j++;
//             }
//             else{
//                 i++;
//             }
//         }
//         if(j == m && i <= n) return true;
//         return false;
//     }
// }

//O(N + M)
//S(1)
class Solution {
    public boolean canMakeSubsequence(String s1, String s2) {
        int j = 0, n = s1.length(), m = s2.length();
        for (int i = 0; i < n && j < m; ++i) {
            int a = s1.charAt(i), b = s2.charAt(j);
            if (a == b || a + 1 == b || a - 25 == b)
                ++j;
        }
        return j == m;
    }
}