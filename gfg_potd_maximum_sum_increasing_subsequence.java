class Solution
{
	public int maxSumIS(int arr[], int n)  
	{  
	    //O(N*N)
	    //S(N)
	    int[] prev = new int[n];
	    for(int i = 0; i < n; i++) prev[i] = arr[i];
	    int ans = 0;
	    for(int i = 0; i < n; i++){
	        for(int j = i + 1; j < n; j++){
	            if(arr[i] < arr[j]){
	                prev[j] = Math.max(prev[j], arr[j] + prev[i]);
	            }
	        }
	    }
	    
	    for(int i = 0; i < n; i++){
	        ans = Math.max(ans, prev[i]);
	    }
	    
	    return ans;
	}  
}