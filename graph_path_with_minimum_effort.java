class Solution {
    public int minimumEffortPath(int[][] grid) {
        //O(N*M*log(N*M)*4)
        //S(N*M)
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        for(int[] row : vis){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        q.add(new int[]{0, 0, 0});

        int[] dr = {-1, 0, 1, 0,};
        int[] dc = {0, 1, 0, -1};

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int absDiff = cur[0], row = cur[1], col = cur[2];
            if(row == n-1 && col == m-1) return absDiff;
            for(int k = 0; k < 4; k++){
                int nrow = row + dr[k], ncol = col + dc[k];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m){
                    int curabs = Math.max(absDiff, Math.abs(grid[nrow][ncol] - grid[row][col]));
                    if(curabs < vis[nrow][ncol]){
                        vis[nrow][ncol] = curabs;
                        q.add(new int[]{curabs, nrow, ncol});
                    }
                }
            }
        }
        return vis[n-1][m-1];
    }
}