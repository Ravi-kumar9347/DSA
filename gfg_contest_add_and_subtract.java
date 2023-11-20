class Solution {
    public static int getMaxFreq(int n, int[] A) {
        //O(N)
        //S(N)
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            map.put(A[i] + 1 , map.getOrDefault(A[i] + 1 , 0) + 1);
            map.put(A[i] - 1 , map.getOrDefault(A[i] - 1 , 0) + 1);
        }
        
        int ans = 0;
        for(int c : map.values()){
            ans = Math.max(ans,c);
        }
        return ans;
    }
}