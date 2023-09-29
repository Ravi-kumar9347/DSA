public class Solution {
    static boolean isKthBitSet(int n, int k) {
        int j = n & (1 << (k - 1));
        return j == 0 ? false : true;
    }
}