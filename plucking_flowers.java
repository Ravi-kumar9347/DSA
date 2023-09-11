class Solution 
{ 
    long maximumBeauty(int N, int K, int B[]) 
    { 
        //O(N*K)
        //S(K)
        long[] prev1 = new long[K + 1];
        long[] prev2 = new long[K + 1];
        
        Arrays.fill(prev1, -1 * (long)1e16);
        Arrays.fill(prev2, -1 * (long)1e16);
        
        prev1[K] = 0;
        prev2[K] = 0;
        
        for(int i = N - 1; i >= 0; i--){
            long[] cur = new long[K + 1];
            for(int j = K - 1; j >= 0; j--){
                cur[j] = Math.max(prev1[j], B[i] + prev2[j + 1]);
            }
            prev2 = prev1;
            prev1 = cur;
        }
        
        return prev1[0];
    }
} 