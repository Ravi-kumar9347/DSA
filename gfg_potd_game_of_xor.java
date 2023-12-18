class Solution {
    static int gameOfXor(int n , int[] a) {
        //O(N)
        //S(1)
        int result = 0;
        for(int i = 0; i < n; i++){
            int occurences = (n - i) * (i + 1);
            if(occurences % 2 == 1){
                result ^= a[i];
            }
        }
        return result;
    }
}