public class Solution {
    public static int[] bitManipulation(int n, int i){
        int[] result = new int[3];
        int j = n & (1 << (i - 1));
        result[0] = j == 0 ? 0 : 1;
        result[1] = n | (1 << (i - 1));
        result[2] = n & (~(1 << (i - 1)));

        return result;
    }
}
