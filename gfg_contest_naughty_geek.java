class Solution {
    public static long totalWays(int N) {
        //O(N)
        //S(1)
        long ans = 1;
        for(int i = 1; i <= N; i++){
            ans *= i;
        }
        return ans;
    }
}