class Solution {
    int isPalindrome(String s) {
        //O(N)
        //S(1)
        int i = 0, j = s.length() - 1;
        
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return 0;
            i++;
            j--;
        }
        
        return 1;
    }
};