class Solution{
    static long sumOfDivisors(int N){
        //O(N)
        //S(1)
        long ans = 0;
        for(int i = 1; i <= N; i++){
            ans += (N / i) * i;
        }
        return ans;
    }
}