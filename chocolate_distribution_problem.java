class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        //O(N logN)
        //S(1)
        Collections.sort(a);
        
        int minValue = Integer.MAX_VALUE;
        for(int i = m - 1; i < n; i++){
            minValue = Math.min(minValue, a.get(i) - a.get(i - m + 1));
        }
        return minValue;
    }
}