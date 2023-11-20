class Solution {
    public int numEnclaves(int[][] grid) {
        //O(N*M)
        //S(N*M)
        int m = grid.length, n = grid[0].length;
        int[][] vis = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if((i == 0 || i == m-1 || j == 0 || j == n-1) && grid[i][j] == 1){
                    dfs(i, j, grid, vis, m, n);
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(vis[i][j] == 0 && grid[i][j] == 1){
                    ans++;
                }
            }
        }

        return ans;
    }

    private static void dfs(int i, int j, int[][] grid, int[][] vis, int m, int n){
        vis[i][j] = 1;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        for(int k = 0; k < 4; k++){
            int nrow = i + dr[k], ncol = j + dc[k];
            if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                dfs(nrow, ncol, grid, vis, m, n);
            }
        }
    }
}