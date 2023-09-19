class Solution
{
    //Function to find position of first set bit in the given number.
    public static int getFirstSetBit(int n){
        //O(logN)
        //S(1)
        int ind = 0;
        
        while(n > 0){
            if((n & 1) == 1){
                ind++;
                return ind;
            }
            n >>= 1;
            ind++;
        }    
        
        return ind;
    }
}