class Solution
{
    //Function to find the first position with different bits.
    public static int posOfRightMostDiffBit(int m, int n)
    {
        //O(max(logn, logm))
        //S(1)
        if(m == n) return -1;
        
        int i = 1;
        while((m & (1 << (i-1))) == (n & (1 << (i-1)))){
            i++;
        }
        
        return i;
    }
}
