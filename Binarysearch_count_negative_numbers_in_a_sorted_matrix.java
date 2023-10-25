class Solution {
    public int countNegatives(int[][] grid) {
        //O(N+M)
        //S(1)
        int n = grid.length, m = grid[0].length, count = 0, row = 0, col = m - 1;
        while(row < n && col >= 0){
            if(grid[row][col] < 0){
                count += (n - row);
                col--;
            }
            else{
                row++;
            }
        }
        return count;
    }
}