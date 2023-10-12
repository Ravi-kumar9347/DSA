import java.util.* ;
import java.io.*; 

public class Solution {

	public static int sqrtN(long N) {
		//O(logN)
		//S(1)
		long low = 0, high = N;
		while(low <= high){
			long mid = (low + high) / 2;
			if(mid * mid == N) return (int)mid;
			if(mid * mid < N){
				low = mid + 1;
			} 
			else high = mid - 1;
		}

		return high;
	}
}
