class Solution {
    public int[][] merge(int[][] intervals) {
        //O(NlogN)
        //S(1)
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();
        int mini = intervals[0][0];
        int maxi = intervals[0][1];

        for(int i = 1; i < intervals.length; i++){
            if(maxi >= intervals[i][0]){
                //mini = Math.min(mini, intervals[i][0]); we already sorted based on start value
                maxi = Math.max(maxi, intervals[i][1]);
            }
            else{
                result.add(new int[]{mini, maxi});
                mini = intervals[i][0];
                maxi = intervals[i][1];
            }
        }
        result.add(new int[]{mini, maxi});   

        return result.toArray(new int[result.size()][]);     
    }
}