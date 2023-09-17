
class Solution
{
    //Function to return list containing first n fibonacci numbers.
    public static long[] printFibb(int n) 
    {
        //O(N) S(N)
        long[] fibonacii = new long[n];
        fibonacii[0] = 1;
        if(n == 1) return fibonacii;
        fibonacii[1] = 1;
        long prev1 = 1, prev2 = 1, cur = 0;
        for(int i = 3; i <= n; i++){
            cur = prev2 + prev1;
            fibonacii[i-1] = cur;
            prev2 = prev1;
            prev1 = cur;
        }
        
        return fibonacii;
    }
}