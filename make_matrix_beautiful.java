
class Solution {
    public static int findMinOperation(int N, int[][] matrix) {
        // code here
        //take rowSum or colSum
        //O(N*N)
        //S(N)
        int[] rowSum = new int[N];
        int maxValue = 0;
        
        for(int i = 0; i < N; i++){
            int row = 0, col = 0;
            for(int j = 0; j < N; j++){
                row += matrix[j][i];
                col += matrix[i][j];
            }
            rowSum[i] = row;
            maxValue = Math.max(maxValue, Math.max(row, col));
        }
        
        int result = 0;
        for(int num : rowSum){
            result += maxValue - num;
        }
        
        return result;
    }
}