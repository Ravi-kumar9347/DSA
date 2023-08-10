import java.util.* ;
import java.io.*; 
import java.util.*;
public class Solution {
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		//O(N)
		int prev1 = nums.get(0);
		int prev2 = 0;
		for(int i = 1; i < nums.size(); i++){
			int cur = Math.max(prev1 , nums.get(i) + prev2);
			prev2 = prev1;
			prev1 = cur;
		}

		return prev1;
	}
}