class Solution 
{ 
    long maxSum(int N, int A[]) 
    { 
        //O(N)
        //S(1)
        //all are positives -> we can add to our total
        // even no. of negatives -> we can add to our total
        // atleast one zero -> we can add to our total
        //even no.of negatives -> we can add to our total by converting to all positives
        
        long ans = 0, min_abs = -1, countNegatives = 0, countZeroes = 0;
        for(int i = 0; i < N; i++){
            long val = (long)(i + 1) * (N - i); // no of sub arrays that the element will present
            val =(long)val * A[i]; // multiply the element into no.of times it occured
            
            if(A[i] < 0) countNegatives++;
            if(A[i] == 0) countZeroes++;
            
            ans += Math.abs(val);
            
            if(min_abs == -1){
                min_abs = Math.abs(val);
            }
            else{
                min_abs = Math.min(min_abs, Math.abs(val));
            }
        }
        
        if(countNegatives % 2 == 0 || countZeroes > 0){
            return ans;
        }
        return ans - 2 * min_abs;
    }
} 