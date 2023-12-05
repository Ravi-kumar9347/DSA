class Solution {
    int getMinDiff(int[] arr, int n, int k) {
        //O(NlogN)
        //S(1)
        Arrays.sort(arr);
        int ans = arr[n-1] - arr[0];
        
        for(int i = 1; i < n; i++){
            if(arr[i] < k) continue;
            
            int mini = Math.min(arr[0] + k, arr[i] - k);
            int maxi = Math.max(arr[n-1] - k, arr[i-1] + k);
            
            ans = Math.min(ans, maxi - mini);
        }
        
        return ans;
    }
}