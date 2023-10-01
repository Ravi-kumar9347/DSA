class Solution
{
    //Function to return list of integers that form the boundary 
    //traversal of the matrix in a clockwise manner.
    static ArrayList<Integer> boundaryTraversal(int matrix[][], int n, int m)
    {
        //O(N+M)
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int j = 0; j < m; j++) {
                result.add(matrix[0][j]);
        }
        
        // Traverse the rightmost column
        for (int i = 1; i < n; i++) {
            result.add(matrix[i][m - 1]);
        }
        
        // Traverse the bottom row
        if(n > 1){
            for (int j = m - 2; j >= 0; j--) {
                result.add(matrix[n - 1][j]);
            }
        }
        
        // Traverse the leftmost column
        if(m > 1){
            for (int i = n - 2; i >= 1; i--) {
                result.add(matrix[i][0]);
            }
        }
        
        return result;
    }
}
