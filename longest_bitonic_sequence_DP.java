import java.util.* ;
import java.io.*; 
public class Solution {
    public static int longestBitonicSequence(int[] nums, int n) {
        //O(N*N)
        //S(N)
        int[] front = new int[n];
        int[] back = new int[n];
        Arrays.fill(front, 1);
        Arrays.fill(back, 1);
		
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    front[i] = Math.max(front[i], 1 + front[j]);
                }
            }
        }
		
        for(int i = n - 2; i >= 0; i--){
            for(int j = i + 1; j < n; j++){
                if(nums[i] > nums[j]){
                    back[i] = Math.max(back[i], 1 + back[j]);
                }
            }
        }

		int ans = 0;
		for(int i = 0; i < n; i++){
			ans = Math.max(ans, front[i] + back[i] - 1);
		}				
		
		return ans;
    }
}