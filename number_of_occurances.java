
class Solution {
    int count(int[] arr, int n, int x) {
        // code here
        int low = 0, high = n - 1;
        int count = 0;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == x){
                count++;
                int i = mid - 1;
                int j = mid + 1;
                while(i >= 0 && arr[i] == x){
                    count++;
                    i--;
                }
                while(j < n && arr[j] == x){
                    count++;
                    j++;
                }
                return count;
            }
            if(arr[mid] < x) low = mid + 1;
            else high = mid - 1;
        }
        return count;
    }
}