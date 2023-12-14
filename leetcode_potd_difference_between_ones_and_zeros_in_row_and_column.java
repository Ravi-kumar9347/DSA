class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        //O(N*M)
        //S(N*M)
        int m = grid.length;
        int n = grid[0].length;
        int[] rowOnes = new int[m];
        int[] colOnes = new int[n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    rowOnes[i]++;
                    colOnes[j]++;
                }
            }
        }

        int[][] result = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                result[i][j] = (rowOnes[i] + colOnes[j]) - ((m - rowOnes[i]) + (n - colOnes[j]));
            }
        }

        return result;
    }
}