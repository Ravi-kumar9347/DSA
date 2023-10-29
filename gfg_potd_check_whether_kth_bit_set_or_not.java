
class CheckBit
{
    // Function to check if Kth bit is set or not.
    static boolean checkKthBit(int n, int k)
    {
        //S(1)
        //O(1)
        int bit = n & (1 << k);
        return bit == 0 ? false : true;
    }
    
}