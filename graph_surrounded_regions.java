class Solution {
    public void solve(char[][] board) {
        //O(N*M)
        //S(N*M)
        int m = board.length, n = board[0].length;
        int[][] vis = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if((i == 0 || i == m-1 || j == 0 || j == n-1) && board[i][j] == 'O'){
                    dfs(i, j, board, vis, m, n);
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(vis[i][j] == 0 && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    private static void dfs(int i, int j, char[][] board, int[][] vis, int m, int n){
        vis[i][j] = 1;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        for(int k = 0; k < 4; k++){
            int nrow = i + dr[k] , ncol = j + dc[k];
            if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && vis[nrow][ncol] == 0 && board[nrow][ncol] == 'O'){
                dfs(nrow, ncol, board, vis, m, n);
            }
        }
    }
}