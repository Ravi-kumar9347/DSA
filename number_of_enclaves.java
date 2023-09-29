class Solution {

    int numberOfEnclaves(int[][] grid) {
        //O(N*M)
        //S(N*M)
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if((i == 0 || i == n - 1 || j == 0 || j == m - 1) && grid[i][j] == 1 && vis[i][j] == 0){
                    dfs(i, j, grid, vis, n, m);
                }
            }
        }
        
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && vis[i][j] == 0) count++;
            }
        }
        
        return count;
    }
    
    private static void dfs(int i, int j, int[][] grid, int[][] vis, int n, int m){
        vis[i][j] = 1;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        
        for(int k = 0; k < 4; k++){
            int nrow = i + dr[k];
            int ncol = j + dc[k];
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1 && vis[nrow][ncol] == 0){
                dfs(nrow, ncol, grid, vis, n, m);
            }
        }
    }
}
