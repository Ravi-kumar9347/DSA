class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        //O(N*M)
        //S(1)
        int curColor = image[sr][sc];
        int m = image.length, n = image[0].length;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        if(curColor != color){
            dfs(sr, sc, image, curColor, color, dr, dc, m, n);
        }

        return image;
    }

    private static void dfs(int i, int j, int[][] image, int cur, int color, int[] dr, int[] dc, int m, int n){
        image[i][j] = color;

        for(int k = 0; k < 4; k++){
            int di = i + dr[k];
            int dj = j + dc[k];
            if(di >= 0 && di < m && dj >= 0 && dj < n && image[di][dj] == cur){
                dfs(di, dj, image, cur, color, dr, dc, m, n);
            }
        }
    }
}