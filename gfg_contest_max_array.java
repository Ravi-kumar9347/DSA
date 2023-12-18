class Solution{
    
    int minOperations(int a[], int N) 
    { 
        //O(N)
        //S(1)
        int maxi = -1;
        for(int num : a){
            maxi = Math.max(maxi, num);
        }
        
        int maxiCount = 0;
        int right = 0, left = 0;
        int maxiLength = 0;
        while(right < N){
            if(a[right] != maxi){
                right++;
                left = right;
            }
            
            while(right < N && a[right] == maxi){
                right++;
            }
            
            maxiCount += (right - left);
            maxiLength = Math.max(maxiLength, right - left);
        }
        
        return maxiCount - maxiLength;
    } 
}