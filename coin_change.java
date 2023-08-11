class Solution {
    public long count(int coins[], int N, int sum) {
        //O(sum * N)
        //S(sum)
        long[] prev = new long[sum + 1];
        
        for(int i = 0; i < N; i++){
            long[] cur = new long[sum + 1];
            cur[0] = 1;
            for(int s = 1; s < sum + 1; s++){
                long notTake = 0;
                if(i > 0) notTake = prev[s];
                long take = 0;
                if(s - coins[i] >= 0) take = cur[s - coins[i]];
                cur[s] = notTake + take;
            }
            prev = cur;
        }
        
        return prev[sum];
    }
}