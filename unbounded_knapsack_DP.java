public class Solution {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
		//O(N*W)
		//S(W)
        int[] prev = new int[w+1];
		for(int i = n - 1; i >= 0; i--){
			int[] cur = new int[w+1];
			for(int j = w; j >= 0; j--){
				int notTake = prev[j];
				int take = 0;
				if(j + weight[i] <= w) take = profit[i] + cur[j + weight[i]];
				cur[j] = Math.max(notTake, take);
			}
			prev = cur;
		}
		return prev[0];
    }
}
