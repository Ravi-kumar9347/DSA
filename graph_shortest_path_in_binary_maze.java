class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        //O(N*M*8)
        //S(N*M)
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;

        int[][] vis = new int[n][n];
        for(int[] row : vis){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        vis[0][0] = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1});

        int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int row = cur[0], col = cur[1], dist = cur[2];
            if(row == n-1 && col == n-1) return dist;
            for(int k = 0; k < 8; k++){
                int nrow = row + dr[k], ncol = col + dc[k];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && grid[nrow][ncol] == 0 && 1 + dist < vis[nrow][ncol]){
                    vis[nrow][ncol] = 1 + dist;
                    q.add(new int[]{nrow, ncol, 1+dist});
                }
            }
        }
        return vis[n-1][n-1] == Integer.MAX_VALUE ? -1 : vis[n-1][n-1];
    }
}