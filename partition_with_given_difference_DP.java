import java.util.* ;
import java.io.*; 
public class Solution {
	public static int countPartitions(int n, int d, int[] num) {
		int sum = 0;
		for(int i : num) sum += i;
		
		if((sum + d) % 2 == 1) return 0;
		int tar = ((sum + d) / 2) ;
		
		//O(N * tar)
	    //S(tar)
	    int mod = (int)1e9 + 7;
        int[] prev = new int[tar + 1];
        prev[tar] = 1;

        for(int i = n - 1; i >= 0; i--){
            int[] cur = new int[tar + 1];
            for(int s = tar; s >= 0; s--){
                int notTake = prev[s];
                int take = 0;
                if(s + num[i] <= tar) take = prev[s + num[i]];
                
                cur[s] = (notTake + take) % mod;
            }
            prev = cur;
        }
        return prev[0];
	}
}