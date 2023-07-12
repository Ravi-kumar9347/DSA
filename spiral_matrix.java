class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();

        if(matrix.length == 0 || matrix[0].length == 0) return result;

        int rowStart = 0, rowEnd = matrix.length - 1;
        int colStart = 0, colEnd = matrix[0].length - 1;

        while(rowStart <= rowEnd && colStart <= colEnd){
            for(int col = colStart; col <= colEnd; col++){
                result.add(matrix[rowStart][col]);
            }
            rowStart++;

            for(int row = rowStart; row <= rowEnd; row++){
                result.add(matrix[row][colEnd]);
            }
            colEnd--;

            if(rowStart <= rowEnd){
                for(int col = colEnd; col >= colStart; col--){
                    result.add(matrix[rowEnd][col]);
                }
                rowEnd--;
            }

            if(colStart <= colEnd){
                for(int row = rowEnd; row >= rowStart; row--){
                    result.add(matrix[row][colStart]);
                }
                colStart++;
            }
        }

        return result;
    }
}