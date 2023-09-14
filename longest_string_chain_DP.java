class Solution {

    private static boolean isPossible(String s, String t){
        int slen = s.length();
        int tlen = t.length();

        if(slen + 1 != tlen) return false;

        int i = 0, j = 0;

        while(i < slen && j < tlen){
            if(s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            }
            else{
                j++;
            }
        }

        if(i == slen && (j == tlen || j == tlen - 1)){
            return true;
        }
        return false;
    }
    public int longestStrChain(String[] words) {
        //O(N*N)
        //S(N)
        int n = words.length;
        Arrays.sort(words, (a, b) -> a.length() - b.length());        
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int lsc = 1;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(isPossible(words[i], words[j])){
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                    lsc = Math.max(lsc, dp[j]);
                }
            }
        }

        return lsc;
    }
}


//O(N logN) + O(N * 16)
//S(N * 16)

// public int longestStrChain(String[] words) {
//     Map<String, Integer> dp = new HashMap<>();   
//     Arrays.sort(words, (a, b)->a.length() - b.length());
//     int res = 0;
//     for (String word : words) {
//         int best = 0;
//         for (int i = 0; i < word.length(); ++i) {
//             String prev = word.substring(0, i) + word.substring(i + 1);
//             best = Math.max(best, dp.getOrDefault(prev, 0) + 1);
//         }
//         dp.put(word, best);
//         res = Math.max(res, best);
//     }
//     return res;
// }