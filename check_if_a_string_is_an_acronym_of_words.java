class Solution {
    public boolean isAcronym(List<String> words, String s) {
        //O(w)
        //S(1)
        int w = words.size();
        int len = s.length();
        int j = 0, i = 0;
        while(j < len && i < w){
            if(words.get(i).charAt(0) != s.charAt(j)) return false;
            j++;
            i++;
        }
        if(j == len && i == w) return true;
        return false;
    }
}