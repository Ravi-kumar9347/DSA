
class Solution {
    int transitionPoint(int arr[], int n) {
        //O(logN)
        //S(1)
        int low = 0, high = n - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == 1){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low < n ? low : -1;
    }
}