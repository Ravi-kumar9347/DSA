class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        //O(NlogN)
        //S(1)
        Arrays.sort(points, (int[] a, int[] b) -> a[0] - b[0]);
        int ans = 0;
        for(int i = 1; i < points.length; i++){
            ans = Math.max(ans, points[i][0] - points[i-1][0]);
        }

        return ans;
    }
}