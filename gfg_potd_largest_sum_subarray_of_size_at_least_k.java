
class Solution {
    
    public long maxSumWithK(long a[], long n, long k)
    //O(N)
    //S(N)
    {
        long maxi = 0, sum = 0, prev = 0;
        int i = 0, j = 0;
        for( ; i < k; i++){
            sum += a[i];
        }
        
        maxi = sum;
        
        while(i < n){
            sum += a[i++];
            prev += a[j++];
            maxi = Math.max(maxi, sum);
            
            if(prev < 0){
                sum -= prev;
                prev = 0;
                maxi = Math.max(maxi, sum);
            }
        }
        
        return maxi;
    }
}
