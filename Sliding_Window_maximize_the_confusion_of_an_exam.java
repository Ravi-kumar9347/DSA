class Solution {
    private int max(char c, String s, int k){
        int left = 0, right = 0, cnt = 0, ans = 0;

        while(right < s.length()){
            if(s.charAt(right) == c){
                cnt++;
            }
            while(cnt > k){
                if(s.charAt(left) == c){
                    cnt--;
                }
                left++;
            }
            ans = Math.max(ans, right - left +1);
            right++;
        }
        return ans;
    }
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int ans = Math.max(max('T', answerKey, k), max('F', answerKey, k));
        return ans;
    }
}