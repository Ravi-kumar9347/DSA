class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //O(NlogN)
        int row,column,low=0,high=matrix.length*matrix[0].length-1,mid;
        while(low<=high){
            mid=(low+high)/2;
            row=mid/matrix[0].length;
            column=mid%matrix[0].length;

            if (target==matrix[row][column]) {
             return true;
            }else if(target<matrix[row][column]){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return false;
    }
}