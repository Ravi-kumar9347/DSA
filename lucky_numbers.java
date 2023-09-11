class Solution
{
    // Complete the function
    // n: Input n
    // Return True if the given number is a lucky number else return False
    public static boolean isLucky(int n)
    {
        //O(sqrt(N))
        //S(1)
        int x = 2;
        
        while(x <= n){
            if(n % x == 0) return false;
            
            n -= n / x;
            x++;
        }
        
        return true;
    }
}