class Solution {
    
    public int countSubArrayProductLessThanK(long a[], int n, long k)
    {
        int left = 0, right = 0, count = 0;
        long product = a[0];
        
        while(right < n){
            if(product < k){
                count += (right - left + 1);
                right++;
                if(right < n){
                    product *= a[right];
                }
            }
            else{
                product /= a[left];
                
                if(left == right){
                    right++;
                    if(right < n){
                        product *= a[right];
                    }
                }
                left++;
            }
            
        }
        return count;
    }
}