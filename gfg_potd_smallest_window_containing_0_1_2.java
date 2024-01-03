class Solution {
    public int smallestSubstring(String s) {
        //O(N)
        //S(1)
        int n = s.length(), zero = 0, one = 0, two = 0, left = 0, right = 0, mini = (int)1e9;
        while(right < n){
            if(s.charAt(right) == '0') zero++;
            if(s.charAt(right) == '1') one++;
            if(s.charAt(right) == '2') two++;
            
            while(left < n && zero > 0 && one > 0 && two > 0){
                mini = Math.min(mini, zero + one + two);
                
                if(s.charAt(left) == '0') zero--;
                if(s.charAt(left) == '1') one--;
                if(s.charAt(left) == '2') two--;
                
                left++;
            }
            
            right++;
        }
        
        return mini == (int)1e9 ? -1 : mini;
    }
};
