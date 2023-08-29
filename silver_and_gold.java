class Solution {
    public String flipCoins(int N,String s) {
        //O(N)
        //S(1)
        int zeros = 0;
        for(int i = 0; i < N; i++){
            if(s.charAt(i) == '0') zeros++;
        }
        return zeros % 2 == 0 ? "Yes" : "No";
    }
}