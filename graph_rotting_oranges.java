class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        //O(N*M)
        //S(N*M)
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    Pair p = new Pair(i, j);
                    q.add(p);
                    vis[i][j] = 1;
                }
            }
        }

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        int minutes = 0;
        while(!q.isEmpty()){
            int size = q.size();
            minutes++;
            for(int i = 0; i < size; i++){
                Pair p = q.poll();
                int x = p.x, y = p.y;
                for(int k = 0; k < 4; k++){
                    int dx = x + dr[k];
                    int dy = y + dc[k];
                    if(dx >= 0 && dx < m && dy >= 0 && dy < n && grid[dx][dy] == 1 && vis[dx][dy] == 0){
                        q.add(new Pair(dx, dy));
                        vis[dx][dy] = 1;
                    }
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1 && vis[i][j] == 0){
                    return -1;
                }
            }
        }

        return minutes == 0 ? 0 : minutes - 1;
    }
}