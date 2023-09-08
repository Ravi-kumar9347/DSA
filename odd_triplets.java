class Solution 
{ 
    long countTriplet(int N, int A[],int X) 
    { 
        //O(N)
        //S(1)
        long ans = 0, leftodds = 0, rightodds = 0;
        
        for(int i = X; i < N; i++){
            if(A[i] % 2 == 1) rightodds++;
        }
        
        for(int i = 0; i < N; i++){
            
            if(i - X >= 0 && A[i - X] % 2 == 1) leftodds++;
            
            if(A[i] % 2 == 1) ans += leftodds * rightodds;
            
            if(i + X < N && A[i + X] % 2 == 1) rightodds--;
        }
        
        return ans;
    }
} 