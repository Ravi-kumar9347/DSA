class Solution {
    public int hIndex(int[] citations) {
        //O(NlogN)
        //S(1)
        Arrays.sort(citations);
        int n = citations.length;
        int low = 0, high = n - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(citations[mid] == n - mid){
                return citations[mid];
            }
            if(citations[mid] > n - mid){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return n - low;
    }
}