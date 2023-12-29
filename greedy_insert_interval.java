class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        //O(N)
        //S(N)
        List<int[]> merged = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // Add intervals before newInterval (non-overlapping)
        while (i < n && intervals[i][1] < newInterval[0]) {
            merged.add(intervals[i]);
            i++;
        }

        // Merge overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        merged.add(newInterval);

        // Add remaining intervals after newInterval (non-overlapping)
        while (i < n) {
            merged.add(intervals[i]);
            i++;
        }

        return merged.toArray(new int[merged.size()][]);
    }
}