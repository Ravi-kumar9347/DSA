import java.util.* ;
import java.io.*; 
public class Solution {
	public static int getLongestSubarray(int []nums, int k) {
		//O(2N) S(1)
		int left=0,right=0;
		int sum = nums[0];
		int maxLen = 0;
		int n = nums.length;
		while(right<n){
			while(left <= right && sum > k){
				sum -= nums[left];
				left++;
			}
			if(sum == k){
				maxLen = Math.max(maxLen, right - left +1);
			}
			right++;
			if(right<n) sum += nums[right];
		}
		return maxLen;
	}
}