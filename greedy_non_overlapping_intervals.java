class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //O(NlogN)
        //S(1)
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int count = 0;
        int mini = intervals[0][0];
        int maxi = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            if(maxi > intervals[i][0]){
                count++;
                if(maxi > intervals[i][1]){
                    maxi = intervals[i][1];
                }
            }
            else{
                maxi = intervals[i][1];
            }
        }

        return count;
    }
}