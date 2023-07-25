class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        //O(N)
        //S(1)
        List<String> result = new ArrayList<>();
        for(int i = 0; i < words.size(); i++){
            String s = words.get(i);
            String temp = "";
            for(int j = 0; j < s.length(); j++){
                if(s.charAt(j) == separator){
                    if(temp.length() != 0){
                        result.add(temp);
                        temp = "";
                    }
                }
                else{
                    temp += s.charAt(j);
                }
            }
            if(temp.length() != 0) result.add(temp);
        }
        return result;
    }
}