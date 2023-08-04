// class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {
//         return fun(0, s, wordDict);
//     }

//     private boolean fun(int i, String s, List<String> wordDict){
//         if(s.length() == 0) return true;
//         if(i == wordDict.size() && s.length() != 0) return false;
        
//         boolean notTake = fun(i + 1, s, wordDict);
//         boolean take = false;
//         String str = wordDict.get(i);
//         int len = str.length();
//         if(s.length() >= len){
//             String subString = s.substring(0, len);
//             if(str.equals(subString)){
//                 String remaining =  s.substring(len);
//                 take = fun(0, remaining , wordDict);
//             }
//         }
        

//         return notTake || take ;
//     }
// }

// class Solution {
//     Time complexity: ( O(n * m + k) ), where ( n ) is the length of the string, ( m ) is the maximum length of a word in the dictionary, and ( k ) is the total number of characters in all words in the dictionary (for building the Trie).
// Space complexity: ( O(n + k) ), where ( n ) is the length of the string and ( k ) is the total number of characters in all words in the dictionary.
//     public boolean wordBreak(String s, List<String> wordDict) {
//         Map<String, Boolean> memo = new HashMap<>();
//         Set<String> wordSet = new HashSet<>(wordDict);
//         return dfs(s, wordSet, memo);
//     }
    
//     private boolean dfs(String s, Set<String> wordSet, Map<String, Boolean> memo) {
//         if (memo.containsKey(s)) return memo.get(s);
//         if (wordSet.contains(s)) return true;
//         for (int i = 1; i < s.length(); i++) {
//             String prefix = s.substring(0, i);
//             if (wordSet.contains(prefix) && dfs(s.substring(i), wordSet, memo)) {
//                 memo.put(s, true);
//                 return true;
//             }
//         }
//         memo.put(s, false);
//         return false;
//     }
// }

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //O(N * M) n -> s.length(); m-> max len of str in wordDict
        //S(N)
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        int max_len = 0;
        for (String word : wordDict) {
            max_len = Math.max(max_len, word.length());
        }

        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= Math.max(i - max_len - 1, 0); j--) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}