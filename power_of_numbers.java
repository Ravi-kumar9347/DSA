
class Solution
{
    private int mod = (int)(1e9 + 7);
    
    long fun(int n, int r){
        if(r == 0) return 1;
        if(r == 1) return n;
        
        long ans = fun(n, r/2) % mod;
        if(r%2 == 0) return (ans * ans) % mod;
        else return (((ans * ans) % mod) * n) % mod;
    }
    
    long power(int N,int R)
    {
        // O(R l0gR)  S(R l0gR)
        return fun(N, R) % mod;
    }

}