
class Solution
{
    long countWays(int n,int k)
    {
        //O(N)
        //S(1)
        long mod = (long)1e9+7;
        long diff = k, same = 0, total = diff + same;
        for(int i = 2; i <= n; i++){
            same = diff;
            diff = (total * (k - 1)) % mod;
            total = (same + diff) % mod;
        }
        
        return total;
    }
}