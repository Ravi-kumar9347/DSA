class Solution {
    public int minCost(String colors, int[] neededTime) {
        //O(N)
        //S(1)
        int n = colors.length();
        int time = 0;
        for(int i = 1; i < n; i++){
            time += neededTime[i-1];
            int maxi = neededTime[i-1];
            while(i < n && colors.charAt(i-1) == colors.charAt(i)){
                time += neededTime[i];
                maxi = Math.max(maxi, neededTime[i]);
                i++;
            }
            time -= maxi;
        }

        return time;
    }
}