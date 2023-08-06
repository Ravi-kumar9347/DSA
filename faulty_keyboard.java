class Solution {
    public String finalString(String s) {
        //O(N)
        //S(1)
        String result = "";
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'i'){
                StringBuilder reversed = new StringBuilder(result);
                result = reversed.reverse().toString();
                continue;
            }
            else{
                result += s.charAt(i);
            }
        }
        return result;
    }
}