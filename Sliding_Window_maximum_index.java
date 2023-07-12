class Solution {

    int maxIndexDiff(int arr[], int n) {
        //O(N) S(N)
        int[] leftMin = new int[n];
        int[] rightMax = new int[n];
        
        leftMin[0] = arr[0];
        rightMax[n - 1] = arr[n - 1];
        
        for(int i = 1; i < n; i++){
            leftMin[i] = Math.min(leftMin[i - 1], arr[i]);
            rightMax[n - 1 - i] = Math.max(rightMax[n - i], arr[n - i - 1]);
        }
        
        int i = 0, j = 0, ans = 0;
        
        while(j < n){
            if(leftMin[i] <= rightMax[j]){
                ans = Math.max(ans, j - i);
                j++;
            }else{
                i++;
            }
        }
        
        return ans;
    }
}