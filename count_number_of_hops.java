class Solution
{
    // Function to count the number of ways in which frog can reach the top.
    static long countWays(int n)
    {
        //O(N)
        //S(1)
        long mod = (long) 1e9 + 7;
        if (n <= 2) {
            return n;
        }
        
        long a = 1, b = 2, c = 4;
        
        for (int i = 3; i < n; i++) {
            long temp = (a + b + c) % mod;
            a = b;
            b = c;
            c = temp;
        }
        
        return c % mod;
    }
}