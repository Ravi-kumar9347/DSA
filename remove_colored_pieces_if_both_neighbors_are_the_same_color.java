class Solution {
    public boolean winnerOfGame(String s) {
        //O(N)
        //S(1)
        int n = s.length();
        int countA = 0, countB = 0;

        for(int i = 2; i < n; i++){
            if(s.charAt(i - 2) == s.charAt(i - 1) && s.charAt(i - 1) == s.charAt(i)){
                if(s.charAt(i) == 'A'){
                    countA++;
                }
                else{
                    countB++;
                }
            }
        }

        return countA > countB;
    }
}

