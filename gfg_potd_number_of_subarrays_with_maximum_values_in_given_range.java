class Solution{
    
    static long countSubarrays(int a[], int n, int L, int R)  
    { 
        //O(N)
        //S(1)
        long ans = 0, valid = 0, small = 0;
        for(int i = 0; i < n; i++){
            if(a[i] > R){
                ans += (valid * (valid + 1)) / 2;
                ans -= (small * (small + 1)) / 2;
                
                valid = 0;
                small = 0;
            }
            else if(a[i] < L){
                valid++;
                small++;
            }
            else{
                ans -= (small * (small + 1)) / 2;
                small = 0;
                valid++;
            }
        }
        
        ans += (valid * (valid + 1)) / 2;
        ans -= (small * (small + 1)) / 2;
        
        return ans;
    } 
}