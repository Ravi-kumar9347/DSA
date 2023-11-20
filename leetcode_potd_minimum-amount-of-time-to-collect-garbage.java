class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        //O(N)
        //S(1)
        int result = 0, lastIndM = -1, lastIndG = -1, lastIndP = -1, j = 0;
        for(String s : garbage){
            result += s.length();
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == 'M') lastIndM = j;
                if(s.charAt(i) == 'G') lastIndG = j;
                if(s.charAt(i) == 'P') lastIndP = j;
            }
            j++;
        }

        for(int i = 0; i < lastIndM; i++) result += travel[i];
        for(int i = 0; i < lastIndG; i++) result += travel[i];
        for(int i = 0; i < lastIndP; i++) result += travel[i];
        
        return result;
    }
}