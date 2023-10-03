public class Solution {
    public static int findXOR(int L, int R){
        //O(1)
        //S(1)
        return xor(L - 1) ^ xor(R);
    }

    private static int xor(int n){
        if(n % 4 == 0) return n;
        if(n % 4 == 1) return 1;
        if(n % 4 == 2) return n + 1;
        return 0;
    }
}
