class Solution {
    static int minCandy(int n, int ratings[]) {
        //O(N)
        //S(N)
        int[] left = new int[n];
        Arrays.fill(left, 1);
        for(int i = 1; i < n; i++){
            if(ratings[i-1] < ratings[i]){
                left[i] = left[i-1] + 1;
            }
        }
        
        int[] right = new int[n];
        Arrays.fill(right, 1);
        for(int i = n - 2; i >= 0; i--){
            if(ratings[i+1] < ratings[i]){
                right[i] = right[i+1] + 1;
            }
        }
        
        int ans = 0;
        for(int i = 0; i < n; i++){
            ans += Math.max(left[i], right[i]);
        }
        
        return ans;
    }
}
