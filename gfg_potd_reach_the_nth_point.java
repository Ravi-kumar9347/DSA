class Solution
{
    public int nthPoint(int n)
    {
        //O(N)
        //S(1)
        int prev1 = 1;
        int prev2 = 0;
        int mod = (int)1e9+7;
        for(int i = n - 1; i >= 0; i--){
            int cur = (prev1 + prev2) % mod;
            prev2 = prev1;
            prev1 = cur;
        }
        
        return prev1;
    }
}