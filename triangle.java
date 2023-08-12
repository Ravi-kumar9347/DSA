class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        //O(N*N)
        //S(N)
        int n = triangle.size();
        int[] prev = new int[n];
        for(int i = 0; i < n; i++) prev[i] = triangle.get(n-1).get(i);

        for(int i = n - 2; i >= 0; i--){
            int[] cur = new int[n];
            for(int j = i; j >= 0; j--){
                cur[j] = triangle.get(i).get(j) + Math.min(prev[j], prev[j + 1]);
            }
            prev = cur;
        }

        return prev[0];
    }
}