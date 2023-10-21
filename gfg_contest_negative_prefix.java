class Solution 
{ 
    long minOperations(int A[], int N) 
    { 
        //O(N)
        //S(1)
        long count = 0, sum = 0;
        for(int i = 0; i < N; i++){
            sum += A[i];
            if(sum < 0){
                count += (0 - sum);
                sum = 0;
            }
        }
        return count;
    }
} 