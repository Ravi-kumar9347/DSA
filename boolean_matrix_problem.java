class Solution
{
    //Function to modify the matrix such that if a matrix cell matrix[i][j]
    //is 1 then all the cells in its ith row and jth column will become 1.
    void booleanMatrix(int matrix[][])
    {
        //O(N*M)
        //S(N+M)
        int r = matrix.length;
        int c = matrix[0].length;

        //using two list to keep track of the rows and columns 
        //that needs to be updated with 1.
        int row[] = new int[r];
        int col[] = new int[c];
        
        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                //if we get 1 in matrix, we mark ith row and jth column as 1.
                if(matrix[i][j] == 1){
                    row[i] = 1;
                    col[j] = 1;
                }  
            }
        }
        
        for(int i =0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                //if ith row or jth column is marked as 1, then all elements
                //of matrix in that row and column will be 1.
                if(row[i] == 1 || col[j] == 1){
                    matrix[i][j] = 1;
                }
            }
        }
    }
}