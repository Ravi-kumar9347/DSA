class Solution {
    public String FirstNonRepeating(String A) {
        //O(26 * N)
        //S(26)
        int n = A.length();
        Queue<Character> q = new LinkedList<>();
        int[] freq = new int[26];
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < n; i++) {
            freq[A.charAt(i) - 'a']++;

            if (freq[A.charAt(i) - 'a'] == 1) {
                q.add(A.charAt(i));
            }

            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove();
            }

            if (!q.isEmpty()) {
                ans.append(q.peek());
            } else {
                ans.append('#');
            }
        }

        return ans.toString();
    }
}