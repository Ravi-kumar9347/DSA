class Solution {
    public char findTheDifference(String s, String t) {
        //using Map -> O(N) S(N)
       //Bit manupulation -> O(N) S(1)
        int ans = 0;
       for(int i = 0; i < s.length(); i++){
           ans ^= s.charAt(i);
       }
       for(int i = 0; i < t.length(); i++){
           ans ^= t.charAt(i);
       }
       return (char)ans;
    }
}