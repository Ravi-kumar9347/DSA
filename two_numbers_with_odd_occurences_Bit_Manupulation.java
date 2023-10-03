public class Solution {
    public static int[] twoOddNum(int []arr){
        //O(N)
        //S(1)
        int xor = 0;
        for(int num : arr) xor ^= num;

        int i = 0;
        while(xor >= (1 << i)){
            int bit = xor & (1 << i);
            if(bit != 0) break;
            i++;
        }

        int first = 0, second = 0;
        for(int num : arr){
            int bit = num & (1 << i);

            if(bit != 0) first ^= num;
            else second ^= num;
        }
        
        int[] result = new int[2];
        if(second < first){
            result[0] = first;
            result[1] = second;
        }
        else{
            result[0] = second;
            result[1] = first;
        }

        return result;
    }
}
