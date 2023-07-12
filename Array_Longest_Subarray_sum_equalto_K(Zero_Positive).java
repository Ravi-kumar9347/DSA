import java.util.* ;
import java.io.*; 
public class Solution {
	public static int getLongestSubarray(int []nums, int k) {
//O(NlogN) S(N)
		Map<Integer,Integer> mpp = new HashMap<>();
		int longestStreak = 0;
		int preSum = 0;
		for(int i=0;i<nums.length;i++){
			preSum += nums[i];
			if(preSum == k){
				longestStreak = Math.max(longestStreak, i+1);
			} 

			int rem = preSum - k;
			if(mpp.containsKey(rem)){
				longestStreak = Math.max(longestStreak, i - mpp.get(rem));
			}

			if(!mpp.containsKey(rem)){
				mpp.put(preSum,i);
			}
		}
		return longestStreak;
	}
}