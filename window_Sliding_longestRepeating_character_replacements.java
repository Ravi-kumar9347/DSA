class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int left = 0, right = 0;
        int longestSize = 0;
        int maxChar = 0;
        Map<Integer, Integer> mpp = new HashMap<>();
        //O(N) S(1)
        while (right < n) {
            int currChar = s.charAt(right) - 'A';
            mpp.put(currChar, mpp.getOrDefault(currChar, 0) + 1);
            maxChar = Math.max(maxChar, mpp.get(currChar));

            while (right - left + 1 - maxChar > k) {
                int leftChar = s.charAt(left) - 'A';
                mpp.put(leftChar, mpp.get(leftChar) - 1);
                left++;
            }
            longestSize = Math.max(longestSize, right - left + 1);
            right++;
        }
        return longestSize;
    }
}