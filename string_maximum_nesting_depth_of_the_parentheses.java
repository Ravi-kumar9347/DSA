class Solution {
    public int maxDepth(String s) {
        //O(N)
        //S(1)
        int ans = 0;
        int open = 0;
        for(char c : s.toCharArray()){
            if(c == '(') open++;
            else if(c == ')') open--;
            ans = Math.max(ans, open);
        }

        return ans;
    }
}