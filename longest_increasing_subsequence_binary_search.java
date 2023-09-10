
public class Solution {

	public static int longestIncreasingSubsequence(int arr[]) {
	//O(N logN)
	//S(1)
	int n = arr.length;
        int len = 1;
        int[] temp = new int[n];
        temp[0] = arr[0];
        
        for(int i = 1; i < n; i++){
            if(arr[i] > temp[len - 1]){
                temp[len] = arr[i];
                len++;
            }
            else{
                int l = 0, h = len;
                int ind = -1;
                while(l <= h){
                    int m = (l + h) / 2;
                    
                    if(temp[m] >= arr[i]){
                        ind = m;
                        h = m - 1;
                    }
                    else{
                        l = m + 1;
                    }
                }
                
                if(ind != -1){
                    temp[ind] = arr[i];
                }
            }
        }
        return len;
	}

}