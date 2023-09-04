class Solution{
    
    private static boolean isValid(int i, int j, int n, int m, int[][] vis, char[][] a){
        if(i >= 0 && i < n && j >= 0 && j < m && vis[i][j] == 0 && a[i][j] == 'O'){
            return true;
        }
        return false;
    }
    
    private static void dfs(int i, int j, int n, int m, int[][] vis, char[][] a, int[][] change){
        vis[i][j] = 1;
        change[i][j] = 0;
        
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        
        for(int x = 0; x < 4; x++){
            int nrow = i + drow[x];
            int ncol = j + dcol[x];
            if(isValid(nrow, ncol, n, m, vis, a)){
                dfs(nrow, ncol, n, m, vis, a, change);
            }
        }
    }
    
    static char[][] fill(int n, int m, char a[][])
    {
        //O(N*M)
        //S(N*M)
        
        int[][] vis = new int[n][m];
        int[][] change = new int[n][m];
        
        for(int[] row : change) Arrays.fill(row, 1);
        
        for(int j = 0; j < m; j++){
            
            if(isValid(0, j, n, m, vis, a)){
                dfs(0, j, n, m, vis, a, change);
            }
            
            if(isValid(n - 1, j, n, m, vis, a)){
                dfs(n - 1, j, n, m, vis, a, change);
            }
        }
        
        for(int i = 0; i < n; i++){
            
            if(isValid(i, 0, n, m, vis, a)){
                dfs(i, 0, n, m, vis, a, change);
            }
            
            if(isValid(i, m - 1, n, m, vis, a)){
                dfs(i, m - 1, n, m, vis, a, change);
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(change[i][j] == 1){
                    a[i][j] = 'X';
                }
            }
        }
        
        return a;
    }
}