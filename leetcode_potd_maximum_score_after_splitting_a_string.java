class Solution {
    public int maxScore(String s) {
        //O(N)
        //S(1)
        int n = s.length();
        int zero = 0, one = 0;
        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i < n - 1; i++){
            if(s.charAt(i) == '0') zero++;
            else{
                one++;
            } 

            maxi = Math.max(maxi, zero - one);
        }
        if(s.charAt(n-1) == '1') one++;

        return maxi + one;
    }
}