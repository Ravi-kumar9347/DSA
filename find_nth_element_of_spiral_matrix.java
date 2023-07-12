class Solution
{
    /*You are required to complete this method*/
    int findK(int matrix[][], int n, int m, int k)
    {
        //O(N*M) S(1)
        int rowStart = 0, rowEnd = n - 1;
        int colStart = 0, colEnd = m - 1;
        int i = 1;
        
        while(rowStart <= rowEnd && colStart <= colEnd){
            for(int col = colStart; col <= colEnd; col++){
                if(i == k) return matrix[rowStart][col];
                i++;
            }
            rowStart++;

            for(int row = rowStart; row <= rowEnd; row++){
                if(i == k) return matrix[row][colEnd];
                i++;
            }
            colEnd--;

            if(rowStart <= rowEnd){
                for(int col = colEnd; col >= colStart; col--){
                    if(i == k) return matrix[rowEnd][col];
                    i++;
                }
                rowEnd--;
            }

            if(colStart <= colEnd){
                for(int row = rowEnd; row >= rowStart; row--){
                    if(i == k) return matrix[row][colStart];
                    i++;
                }
                colStart++;
            }
        }

        return -1;
    }
}