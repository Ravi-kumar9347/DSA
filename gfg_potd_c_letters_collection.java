//User function Template for Java

// class Solution{
//     static List<Integer> matrixSum(int n, int m, int mat[][], int q, int queries[][])
//     {
//         List<Integer> result = new ArrayList<>();
//         for(int i = 0; i < q; i++){
//             int hop = queries[i][0], r = queries[i][1], c = queries[i][2], ans = 0;
//             if(hop == 1){
//                 int dx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
//                 int dy[] = {-1, 0, 1, -1, 1, -1, 0, 1};
//                 ans = fun(r, c, mat, dx, dy, n, m, 8);
//             } else{
//                 int dx[] = {-2, -2, 2, 2, -2, 2, 0, 0, -2, -2, 2, 2, -1, 1, -1, 1};
//                 int dy[] = {-2, 2, -2, 2, 0, 0, -2, 2, -1, 1, -1, 1, -2, -2, 2, 2}; 
//                 ans = fun(r, c, mat, dx, dy, n, m, 16);
//             }
//             result.add(ans);
//         }
        
//         return result;
//     }
    
//     static int fun(int r, int c, int[][] mat, int[] dx, int[] dy, int n, int m, int k){
//         int ans = 0;
//         for(int i = 0; i < k; i++){
//             int nr = r + dx[i], nc = c + dy[i];
//             if(nr >= 0 && nr < n && nc >= 0 && nc < m){
//                 ans += mat[nr][nc];
//             }
//         }
//         return ans;
//     }
// }

class Solution {
    // Function to check if given indices are valid within the matrix
    private static boolean valid(int i, int j, int n, int m) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }

    // Function to calculate the sum of elements within the specified queries
    static List<Integer> matrixSum(int n, int m, int[][] mat, int q, int[][] queries) {
        List<Integer> result = new ArrayList<>();
        //O(Q)
        //S(1)
        
        // Loop over each query
        for (int i = 0; i < q; i++) {
            int sum = 0;

            // Calculate the indices for the top-left and the bottom-right corners of the submatrix
            int il = queries[i][1] - queries[i][0];
            int jl = queries[i][2] - queries[i][0];
            int ir = queries[i][1] + queries[i][0];
            int jr = queries[i][2] + queries[i][0];

            // Iterate over the rows of the submatrix
            for (int j = il; j <= ir; j++) {
                // Check if the current index is valid, and if so, add the corresponding element to the sum
                if (valid(j, jl, n, m))
                    sum += mat[j][jl];
                if (valid(j, jr, n, m))
                    sum += mat[j][jr];
            }

            // Iterate over the columns of the submatrix
            for (int j = jl + 1; j < jr; j++) {
                // Check if the current index is valid, and if so, add the corresponding element to the sum
                if (valid(il, j, n, m))
                    sum += mat[il][j];
                if (valid(ir, j, n, m))
                    sum += mat[ir][j];
            }

            // Store the sum for the current query in the result list
            result.add(sum);
        }

        // Return the list containing the sums for all queries
        return result;
    }
}