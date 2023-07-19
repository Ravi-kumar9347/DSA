class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // int n = intervals.length;
        // Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        // int count = 0, left = 0, right = 0;

        // while(right < n){
        //     if(intervals[left][1] <= intervals[right][0]){
        //         left = right;
        //     }
        //     else if(intervals[left][1] <= intervals[right][1]){
        //         count++;
        //     }
        //     else if(intervals[left][1] > intervals[right][1]){
        //         count++;
        //         left = right;
        //     }
        //     right++;
        // }
        // return count - 1;

        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
	//O(N)
        int prev = 0;
        int count = 1;

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= intervals[prev][1]) {
                prev = i;
                count++;
            }
        }
        return n - count;
    }   
}