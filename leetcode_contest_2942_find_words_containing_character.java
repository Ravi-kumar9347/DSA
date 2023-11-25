class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        //O(N)
        //S(1)
        List<Integer> result = new ArrayList<>();
        int j = 0;
        for(String s : words){
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == x){
                    result.add(j);
                    break;
                }
            }
            j++;
        }
        return result;
    }
}