class Solution
{
    
    ArrayList<Integer> rotate(int N, int D)
    {
        D = D % 16;
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        //do left shift && and right shift for (16 - D) to fit in 16bits .becuase int is 32 bit and then do & of 1 for last 16 bits .i.e.. 2^16 - 1 == 65535 -> for left shift
        
        int left = (N << D | N >> (16 - D)) & 65535;
        int right = (N >> D | N << (16 - D)) & 65535;
        
        result.add(left);
        result.add(right);
        
        return result;
    }
}