class Solution {
    public static long minCost(int n, int[] p, int[] f) {
        //O(n*n)
        //S(n)
        long[] prev = new long[n+1];
        Arrays.fill(prev, Integer.MAX_VALUE);
        prev[0] = 0;
        
        for(int i = n - 1; i >= 0; i--){
            long[] cur = new long[n+1];
            for(int j = 0; j <= n; j++){
                long notTake = prev[j];
                long take = Integer.MAX_VALUE;
                if(j - f[i] - 1 <= 0) take = p[i];
                else if(j - f[i] - 1 <= n) take = p[i] + prev[j - f[i] - 1];
                cur[j] = Math.min(notTake, take);
            }
            prev = cur;
        }
        
        return prev[n];
    }
}