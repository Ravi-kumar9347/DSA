
class Solution
{
    //Function to return list of integers visited in snake pattern in matrix.
    static ArrayList<Integer> snakePattern(int matrix[][])
    {
        //O(N*N)
        //S(1)
        int n = matrix.length;
        ArrayList<Integer> result = new ArrayList<>();
        boolean isEven = true;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(isEven) result.add(matrix[i][j]);
                else result.add(matrix[i][n-j-1]);
            }
            isEven = !isEven;
        }
        return result;
    }
}