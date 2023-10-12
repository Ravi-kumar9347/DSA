public class Solution {
    public static int NthRoot(int n, int m) {
		//O(log(N+M))
		//S(1)
        int low = 1, high = m;
		while(low <= high){
			int mid = (low + high) / 2;
			int val = cal(mid, n, m);
			if(val == 1) return mid;
			if(val == 0) low = mid + 1;
			else high = mid - 1;
		}
		return -1;
    }
	
	//1 -> ans == m
	//0 -> ans < m
	//-1 -> ans > m
	private static int cal(int mid, int n, int m){
		long ans = 1;
		for(int i = 0; i < n; i++){
			ans *= mid;
			if(ans > m) return -1;
		}
		if(ans == m) return 1;
		return 0;
	}
}
