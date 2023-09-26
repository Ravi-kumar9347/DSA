class Solution {
    public String removeDuplicateLetters(String s) {
        //O(N)
        //S(1)
        int n =s.length();

        int[] frequency = new int[26];
        for(int i = 0; i < n; i++){
            frequency[s.charAt(i) - 'a']++;
        }

        int[] vis = new int[26];
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(vis[c - 'a'] == 1){
                frequency[c - 'a']--;
                continue;
            }
            while(!st.isEmpty() && st.peek() > c && frequency[st.peek() - 'a'] > 0){
                vis[st.peek() - 'a'] = 0;
                st.pop();
            }
            st.add(c);
            vis[c - 'a'] = 1;
            frequency[c - 'a']--;
        }

        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()){
            ans.insert(0, st.pop());
        }

        return ans.toString();
    }
}