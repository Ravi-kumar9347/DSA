class Solution{
    
    // Function to check if given number n is a power of two.
    public static boolean isPowerofTwo(long n){
        //O(1)
        return n > 0 && (n & (n - 1)) == 0;
    }
    
}