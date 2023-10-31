class Solution{
public:
	void pushZerosToEnd(int arr[], int n) {
	    //O(N)
	    //S(1)
	    int l = 0, r = 0;
	    while(r < n){
	        if(arr[r] != 0){
	            while(l < r && arr[l] != 0){
	                l++;
	            }
	            arr[l] = arr[r];
	            if(l != r) arr[r] = 0;
	        }
	        r++;
	    }
	}
};