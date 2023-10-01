class Solution {
    //O(N)
    //S(1)
    public String reverseWords(String s) {
        StringBuilder str = new StringBuilder();
        int j = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' '){
                j = str.length();
                str.insert(j, ' ');
                j++;
            }
            else str.insert(j, s.charAt(i));
        }
        return str.toString();
    }
}