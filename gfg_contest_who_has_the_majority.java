
class Solution {
    // Function to find element with more appearances between two elements in an
    // array.
    public int majorityWins(int arr[], int n, int x, int y) {
        //O(N)
        //S(1)
        int c1 = 0, c2 = 0;
        for(int num : arr){
            if(num == x) c1++;
            if(num == y) c2++;
        }
        if(c1 > c2) return x;
        if(c1 < c2) return y;
        return Math.min(x, y);
    }
}
