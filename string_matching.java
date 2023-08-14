class Solution {
    public static int minimum_difference(int n, String[] words) {
        //O(N * N * length of word)
        //S(1)
        int minMoves = (int)1e9;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                minMoves = Math.min(minMoves, Moves(words[i], words[j]));
            }
        }
        return minMoves;
    }
    
    private static int Moves(String s, String t){
        int totalMoves = 0;
        for(int i = 0; i < s.length(); i++){
            totalMoves += Math.abs(s.charAt(i) - t.charAt(i));
        }
        return totalMoves;
    }
}