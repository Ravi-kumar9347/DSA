class Solution {
    //O(N)
    //S(1)
    public int findMaxAverage(int a[], int n) {
        int maxi = Integer.MIN_VALUE;
        for(int num : a){
            maxi = Math.max(maxi, num);
        }
        return maxi;
    }
}