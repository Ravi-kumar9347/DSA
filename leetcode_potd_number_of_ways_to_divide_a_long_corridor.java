class Solution {
    public int numberOfWays(String corridor) {
        //O(N)
        //S(1)
        long ans = 1;
        int mod = (int)1e9+7;
        int countSeats = 0, lastIndex = -1;
        for(int i = 0; i < corridor.length(); i++){
            if(corridor.charAt(i) == 'P') continue;
            
            countSeats++;
            if(countSeats >= 3 && countSeats % 2 == 1){
                int bars = i - lastIndex;
                ans = (ans * bars) % mod;
            }
            lastIndex = i;
        }
        return (countSeats == 0 || countSeats % 2 == 1) ? 0 : (int)ans;
    }
}