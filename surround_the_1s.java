
class Solution
{
    public int  Count(int[][] matrix)
    {
        // code here
        //O(N*M)
        //S(1)
        int n = matrix.length;
        int m = matrix[0].length;
        int totalOnes = 0;
        int[] dr = {-1, 0, 1};
        int[] dc = {-1, 0, 1};
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int val = 0;
                if(matrix[i][j] == 1){
                    for(int di = 0; di < 3; di++){
                        for(int dj = 0; dj < 3; dj++){
                            if(di == 1 && dj == 1) continue;
                            int nrow = i + dr[di];
                            int ncol = j + dc[dj];
                            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && matrix[nrow][ncol] == 0){
                                val++;
                            }
                        }
                    }
                }
                if(val != 0 && val % 2 == 0) totalOnes++;
            }
        }
        return totalOnes;
    }
}