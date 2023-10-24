class Solution {

    private static int maxInCol(int col, int[][] mat){
        int maxVal = -1, maxInd = -1;
        for(int i = 0; i < mat.length; i++){
            if(maxVal < mat[i][col]){
                maxVal = mat[i][col];
                maxInd = i;
            }
        }
        return maxInd;
    }

    public int[] findPeakGrid(int[][] mat) {
        //O(NlogM)
        //S(1)
        int low = 0, high = mat[0].length - 1;
        int[] result = {-1, -1};
        while(low <= high){
            int mid = (low + high) / 2;
            int rowInd = maxInCol(mid, mat);
            int left = mid - 1 >= 0 ? mat[rowInd][mid - 1] : -1;
            int right = mid + 1 < mat[0].length ? mat[rowInd][mid + 1] : -1;

            if(left < mat[rowInd][mid] && right < mat[rowInd][mid]){
                result[0] = rowInd;
                result[1] = mid;
                return result;
            }
            if(left > mat[rowInd][mid]){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return result;
    }
}