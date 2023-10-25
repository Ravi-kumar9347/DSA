
class Solution{
    static int knapSack(int N, int W, int val[], int wt[])
    {
        //O(N*W)
        //S(W)
        int[] prev = new int[W + 1];
        for(int i = N - 1; i >= 0; i--){
            int[] cur = new int[W + 1];
            for(int w = W; w >= 0; w--){
                int notTake = prev[w];
                int take = 0;
                if(w + wt[i] <= W){
                    take = val[i] + cur[w + wt[i]];
                }
                cur[w] = Math.max(notTake, take);
            }
            prev = cur;
        }
        return prev[0];
    }
}