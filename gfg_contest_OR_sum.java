class Solution 
{ 
    int orSum(int N, int A[], int M, int B[]) 
    { 
        //O(N) + O(M)
        //S(30)
        //check for 0 to 30 bits which are set, if ith bit is set then increament count of ith in count arra
        int mod = (int)1e9 + 7;
        long c1[] = new long[30];
        long c2[] = new long[30];
        
        for(int i = 0; i < N; i++){
            for(int bit = 0; bit < 30; bit++){
                //check for 0 to 30 bits which are set
                c1[bit] += (A[i] % 2);
                A[i] /= 2;
            }
        }
        
        for(int i = 0; i < M; i++){
            for(int bit = 0; bit < 30; bit++){
                //check for 0 to 30 bits which are set
                c2[bit] += (B[i] % 2);
                B[i] /= 2;
            }
        }
        
        long ans = 0;
        for(int i = 0, j = 1; i < 30; i++, j *= 2){
            ans = ans + (((((c1[i] * c2[i]) + (c1[i] * (M - c2[i])) + ((N - c1[i]) * c2[i])) % mod) * j)) % mod;
            ans = ans % mod;
        }
        
        return (int)ans;
    }
} 
