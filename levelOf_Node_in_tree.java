class Solution{
    public long FindLevel(long N) {
        long varible = 1;
        long count = 1;
        long ans = 1;
        while(ans < N){
            count = count * (varible + 1);
            ans = ans + count;
            varible += 1;
        }
        return varible;
    }
}