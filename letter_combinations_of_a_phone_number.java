class Solution {
    public List<String> letterCombinations(String digits) {
        //O(4 ^ N)
        
        List<String> result = new ArrayList<>();
        if(digits.length() == 0) return result;

        String[] phoneMap = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack("", digits, phoneMap, result);
        return result;
    }

    private void backtrack(String combination, String nextDigits, String[] phoneMap, List<String> result){
        if(nextDigits.isEmpty()){
            result.add(combination);
        }
        else{
            String letters = phoneMap[nextDigits.charAt(0) - '2'];
            for(char letter : letters.toCharArray()){
                backtrack(combination + letter, nextDigits.substring(1), phoneMap, result);
            }
        } 
    }
}