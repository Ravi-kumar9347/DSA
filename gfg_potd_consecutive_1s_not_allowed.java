class Solution {

    long countStrings(int n) {
        //O(N)
        //S(1)
        if(n == 1) return 2;
        int mod = (int)1e9 + 7;
        long zero = 1, one = 1, total = one + zero;
        while(n-- > 1){
            one = zero;
            zero = total;
            total = (zero + one) % mod;
        }
        return total;
    }
}
