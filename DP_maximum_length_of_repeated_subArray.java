class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        // int maxlength = 0;
        // return fun(n-1, m-1, nums1, nums2,maxlength);

        int prev[]=new int[m+1];
		

		int ans = 0;
		
		for(int i=1;i<=n;i++){
			int cur[]=new int[m+1];
			for(int j=1;j<=m;j++){
				if(nums1[i - 1]==nums2[j - 1]){
					int val = 1 + prev[j-1];
					cur[j] = val;
					ans = Math.max(ans,val);
				}
				else
					cur[j] = 0;
			}
			prev=cur;
		}
		
		return ans;
    }
    // private static int fun(int i, int j, int[] nums1, int[] nums2, int maxlength){
    //     if(i < 0 || j < 0){
    //        return maxlength;
    //     }

    //     int notMatch1 = fun(i-1, j, nums1, nums2, 0);
    //     int notMatch2 = fun(i, j-1, nums1, nums2, 0);
    //     if(nums1[i] == nums2[j]) maxlength = fun(i-1, j-1, nums1,nums2, maxlength + 1);

    //     return Math.max(maxlength, Math.max(notMatch1, notMatch2));
    // }
}