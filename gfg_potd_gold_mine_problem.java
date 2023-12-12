class Solution{
    static int maxGold(int n, int m, int M[][])
    {
        //O(N*M)
        //S(N)
        int[] prev = new int[n];
        for(int i = 0; i < n; i++){
            prev[i] = M[i][m - 1];
        }
        
        for(int i = m - 2; i >= 0; i--){
            int[] cur = new int[n];
            
            for(int j = 0; j < n; j++){
                int topRight = -1, right = prev[j], downRight = -1;
                if(j - 1 >= 0) topRight = prev[j - 1];
                if(j + 1 < n) downRight = prev[j + 1];
                
                cur[j] = M[j][i] + Math.max(topRight, Math.max(right, downRight));
            }
            prev = cur;
        }
        
        int maxi = -1;
        for(int i = 0; i < n; i++){
            maxi = Math.max(maxi, prev[i]);
        }
        
        return maxi;
    }
}