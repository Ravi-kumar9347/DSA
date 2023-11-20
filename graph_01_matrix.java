class Solution {
    public int[][] updateMatrix(int[][] mat) {
        //O(N*M)
        //S(N*M)
        int m = mat.length, n = mat[0].length;
        int[][] result = new int[m][n];
        int[][] vis = new int[m][n];
        Queue<triple> q = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    vis[i][j] = 1;
                    q.add(new triple(i, j, 0));
                }
            }
        }

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        while(!q.isEmpty()){
            triple t = q.poll();
            int row = t.row, col = t.col, cost = t.cost;
            result[row][col] = cost;

            for(int k = 0; k < 4; k++){
                int nrow = t.row + dr[k], ncol = t.col + dc[k];
                if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && vis[nrow][ncol] == 0){
                    vis[nrow][ncol] = 1;
                    q.add(new triple(nrow, ncol, 1+cost));
                }
            }
        }

        return result;
    }
}

class triple{
    int row, col, cost;
    triple(int row, int col, int cost){
        this.row = row;
        this.col = col;
        this.cost = cost;
    }
}