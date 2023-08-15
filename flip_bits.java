
class Solution {

    public static int maxOnes(int a[], int n) {
        //O(N)
        //S(1)
        // kadanes algo -> to find max sum of sub array 
        int countOnes = 0; 
        int sum = 0;
        int ans = 0;
        
        for(int i = 0; i < n; i++){
            if(a[i] == 1){
                a[i] = -1; // we have to flip to 0 -> so no.of 1s decreses
                countOnes++;
            }
            else{
                a[i] = 1; // we can add to our value
            }
            
            sum += a[i];
            ans  = Math.max(ans, sum);
            
            if(sum < 0) sum = 0;
        }
        
        return ans + countOnes;
    }
}