class Solution {
    public int kthGrammar(int n, int k) {
        //O(logK)
        //S(1)
        int c = 0;
        k--;
        while(k > 0){
            int bit = k & 1;
            if(bit == 1) c++;
            k = k >> 1;
        }
        return c % 2 == 0 ? 0 : 1;
    }
}