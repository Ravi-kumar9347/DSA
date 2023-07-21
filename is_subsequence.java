class Solution {
    public boolean isSubsequence(String s, String t) {
        //O(N) S(1)
        int slength = s.length(), tlength = t.length();
        int spointer = 0, tpointer = 0;
        while(tpointer < tlength && spointer < slength){
            if(s.charAt(spointer) == t.charAt(tpointer)){
                spointer++;
            }
            tpointer++;
        }
        
        return spointer == slength ? true : false;
    }
}