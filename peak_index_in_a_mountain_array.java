class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        //O(N logN)
        //S(1)
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        while(left <= right){
            int mid = (left + right) / 2;

            if(arr[mid-1] < arr[mid] && arr[mid] < arr[mid+1]){
                left = mid + 1;
            }
            else if(arr[mid-1] > arr[mid] && arr[mid] > arr[mid+1]){
                right = mid;
            }
            else return mid;
        }
        return -1;
    }
}