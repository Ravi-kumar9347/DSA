public class Solution {
    public static int lowerBound(int []arr, int n, int x) {
        //O(logN)
        //S(1)
        int lb = n, low = 0, high = n - 1;

        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] >= x){
                lb = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return lb;
    }
}