public final class Solution {

    static int upperBound(int []arr, int x, int n){
        int ub = n, low = 0, high = n - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] > x){
                ub = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ub;
    }

    static int smallEqulas(int val, int[][] matrix){
        int count = 0;
        for(int i = 0; i < matrix.length; i++){
            count += upperBound(matrix[i], val, matrix[i].length);
        }
        return count;
    }
    public static int findMedian(int matrix[][], int m, int n) {
        //O(log1e9 * n * logm)
        //S(1)
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for(int i = 0; i < m; i++){
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][n-1]);
        }

        while(low <= high){
            int mid = (low + high) / 2;
            int count = smallEqulas(mid, matrix);
            if(count <= (n * m ) / 2){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        return low;
    }
}