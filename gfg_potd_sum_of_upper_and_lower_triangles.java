class Solution
{
    //Function to return sum of upper and lower triangles of a matrix.
    static ArrayList<Integer> sumTriangles(int matrix[][], int n)
    {
        //O(N*N)
        //S(1)
        ArrayList<Integer> result = new ArrayList<>();
        int up = 0, lp = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(j <= i) lp += matrix[i][j];
                if(j >= i) up += matrix[i][j];
            }
        }
        result.add(up);
        result.add(lp);
        return result;
    }
}