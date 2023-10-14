class Solution {
    public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        List<String> result = new ArrayList<>();
        int prevGroup = -1; // Initialize prevGroup to an invalid value

        for (int i = 0; i < n; i++) {
            if (i == 0 || groups[i] != groups[i - 1]) {
                // If it's the first element or the group is different, add the word to the result
                result.add(words[i]);
                prevGroup = groups[i];
            }
        }

        return result;
    }
}