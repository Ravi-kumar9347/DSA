class Solution {
    public int largestSubmatrix(int[][] matrix) {
        //O(M*N*logN)
        //S(N)
        // int m = matrix.length;
        // int n = matrix[0].length;
        // int[] prevHeights = new int[n];
        // int ans = 0;
        // for(int row = 0; row < m; row++){
        //     int[] curHeights = matrix[row];
        //     for(int col = 0; col < n; col++){
        //         if(curHeights[col] == 1){
        //             curHeights[col] += prevHeights[col];
        //         }
        //     }
        //     Integer[] sortHeights = Arrays.stream(curHeights).boxed().toArray(Integer[]::new);;
        //     Arrays.sort(sortHeights, Comparator.reverseOrder());
        //     for (int i = 0; i < n; i++) {
        //         ans = Math.max(ans, sortHeights[i] * (i+1));
        //     }

        //     prevHeights = curHeights;
        // }
        // return ans;

        //O(M*N)
        //S(N)
        int m = matrix.length;
        int n = matrix[0].length;
        ArrayList<int[]> prevHeights = new ArrayList<>();
        int ans = 0;
        for(int row = 0; row < m; row++){
            ArrayList<int[]> curHeights = new ArrayList<>();
            int[] vis = new int[n];
            for(int[] height : prevHeights){
                if(matrix[row][height[1]] == 1){
                    int[] temp = {height[0]+1, height[1]};
                    curHeights.add(temp);
                    vis[height[1]] = 1;
                }
            }

            for(int col = 0; col < n; col++){
                if(vis[col] == 0 && matrix[row][col] == 1){
                    int[] temp = {1, col};
                    curHeights.add(temp);
                }
            }

            for (int i = 0; i < curHeights.size(); i++) {
                ans = Math.max(ans, curHeights.get(i)[0] * (i + 1));
            }
            prevHeights = curHeights;
        }
        return ans;
    }
}