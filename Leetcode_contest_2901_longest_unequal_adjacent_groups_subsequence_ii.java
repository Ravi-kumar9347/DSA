class Solution {
    public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        //O(N*N)
        //S(N)
        int[] count = new int[n];
        int[] path = new int[n];
        for(int i = 0; i < n; i++) count[i] = 1;
        for(int i = 0; i < n; i++) path[i] = i;
        
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(groups[j] != groups[i] && count[j] <= count[i] && isValid(words[i], words[j])){
                    count[j] = count[i] + 1;
                    path[j] = i;
                }
            }
        }
        
        int maxValue = -1, maxIndex = 0;
        for(int i = 0; i < n; i++){
            if(maxValue < count[i]){
                maxValue = count[i];
                maxIndex = i;
            }
        }
        
        List<String> result = new ArrayList<>();
        int i = maxIndex;
        while(i != path[i]){
            result.add(0, words[i]);
            i = path[i];
        }
        result.add(0, words[i]);
        
        return result;
        
    }
    
    private static boolean isValid(String s1, String s2){
        if(s1.length() != s2.length()) return false;
        int dis = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                dis++;
            }
            if(dis > 1){
                return false;
            }
        }
        return true;
    }
}