class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(intervals[i][0], i);
        }

        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        int[] result = new int[n];

        int j = 0;
        for(int i = n - 1; i >= 0; i--){
            int index = map.get(intervals[i][0]);
            if(intervals[i][0] == intervals[i][1]){
                result[index] = index;
                continue;
            }
            j = i + 1;
            while(j < n && intervals[i][1] > intervals[j][0]){
                j++;
            }
            
            if(j < n){
                int indexResult = map.get(intervals[j][0]);
                result[index] = indexResult;
            }else{
                result[index] = -1;
            }
            
        }

        return result;
    }
}