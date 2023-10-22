
// class Solution{
    
//     long numberOfPaths(int M, int N) {
//         int n = N + M - 2; // to reach destination he has to go , N - 1 steps bottom && M - 1 steps to right
//         //so these are ways , among that we can select either N - 1 steps combination or M - 1 steps
//         int r = M - 1;
//         long result = 1;
//         int mod = (int)1e9 + 7;
//         //below looop is for ncr formula 
//         for(int i = 1; i <= r; i++){
//             result = result * (n - r + i) / i ;
//         }
        
//         return result % mod;
//     }
    
// }


class Solution{
    //O(N*M)
    //S(N)
    public long MOD=1000000007;
    long modpow(long x, long n, long p)
    {
        if (n == 0)
            return 1 % p;
        long ans = 1, base = x;
        while (n > 0)
        {
            if (n % 2 == 1)
            {
                ans = (ans * base) % p;
                n--;
            }
            else
            {
                base = (base * base) % p;
                n /= 2;
            }
        }
        if (ans < 0)
            ans = (ans + p) % p;
        return ans;
    }    
    
    long numberOfPaths(int M, int N) {
        long path = 1;
        for (long i = N; i < (M + N - 1); i++) {
            path = (path*i)%MOD;
            long inv=modpow(i-N+1,MOD-2,MOD);
            path = (path*inv)%MOD;
        }
        return path;        
    }
}