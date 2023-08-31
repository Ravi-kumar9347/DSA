class Solution 
{ 
    boolean graph(int N, int adj[][]) 
    { 
        //O(N * N *N)
        //S(1)
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(i == j && adj[i][j] != 0) return false;
                
                if(adj[i][j] != adj[j][i]) return false;
                
                for(int k = 0; k < N; k++){
                    if(adj[i][k] + adj[k][j] < adj[i][j]) return false;
                }
            }
        }
        return true;
    }
} 