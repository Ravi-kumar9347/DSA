class Solution {
    public int paintWalls(int[] cost, int[] time) {
        //O(N*N)
        //S(N)
        int n = cost.length;
        long[] prev = new long[n + 1];
        Arrays.fill(prev, (long)1e10);
        prev[0] = 0;

        for(int i = n - 1; i >= 0; i--){
            long[] cur = new long[n + 1];
            for(int j = 0; j <= n; j++){
                long notTake = prev[j];
                long take = cost[i];
                if(j - time[i] - 1 > 0){
                    take +=   prev[j - time[i] - 1];
                }

                cur[j] = Math.min(notTake, take);
            }
            prev = cur;
        }

        return (int)prev[n];
    }
}