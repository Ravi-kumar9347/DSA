
class Solution
{
    // Expected Time Complexity: O(9N*N).
    // Expected Auxiliary Space: O(N*N).
    private static boolean isValid(int row, int col, int n, int[][] grid){
        for(int i = 0; i < 9; i++){
            if(grid[row][i] == n){
                return false;
            }
            
            if(grid[i][col] == n){
                return false;
            }
            
            if(grid[(3 * (row / 3)) + (i / 3)][(3 * (col / 3)) + (i % 3)] == n){
                return false;
            }
        }
        return true;
    }
    
    private static boolean solve(int[][] grid){
        for(int row = 0; row < 9; row++){
            for(int col = 0; col < 9; col++){
                if(grid[row][col] == 0){
                    for(int n = 1; n <= 9; n++){
                        if(isValid(row, col, n, grid)){
                            grid[row][col] = n;
                            
                            if(solve(grid)){
                                return true;
                            }
                            else{
                                grid[row][col] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    static boolean SolveSudoku(int grid[][])
    {
        return solve(grid);
    }
    
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
        for(int row = 0; row < 9; row++){
            for(int col = 0; col < 9; col++){
                System.out.print(grid[row][col] + " ");
            }
        }   
    }
}