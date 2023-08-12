class Solution {
    static int nthFibonacci(int n){
        //O(N)
        //S(1)
        long prev2 = 0, prev1 = 1;
        for(int i = 2; i <= n; i++){
            long cur = (prev2 + prev1) % ((long)1e9 + 7);
            prev2 = prev1;
            prev1 = cur;
        }
        return (int)(prev1 % ((long)1e9 + 7));
    }
}