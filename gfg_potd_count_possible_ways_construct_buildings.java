class Solution
{
    public int TotalWays(int n)
    {
        //O(N)
        //S(1)
        int mod = (int)(1e9+7);
        long a = 1, b = 2, total = 2;
        
        for(int i = 2; i <= n; i++){
            total = (a + b) % mod;
            a = b;
            b = total;
        }
        
        total = (total * total) % mod;
        return (int)total;
    }
}