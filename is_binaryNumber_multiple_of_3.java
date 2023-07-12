class Solution {
    int isDivisible(String s) {
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            int digit =  s.charAt(i) - '0';
            if(digit == 1){
                if( i % 2 == 0) ans++;
                else ans += 2;
            }
        }
        
        return ans % 3 == 0 ? 1 : 0;
    }
}