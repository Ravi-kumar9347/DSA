class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        //O(NlogN) + O(MlogM)
        //S(1)
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int hones = 0;
        for(int i = 1; i < hBars.length; i++){
            int count = 0;
            while(i < hBars.length && hBars[i] - hBars[i-1] == 1){
                count++;
                i++;
            }
            hones = Math.max(hones, count);
        }
        
        int vones = 0;
        for(int i = 1; i < vBars.length; i++){
            int count = 0;
            while(i < vBars.length && vBars[i] - vBars[i-1] == 1){
                count++;
                i++;
            }
            vones = Math.max(vones, count);
        }
        
        int min = Math.min(hones, vones) + 2;;
        return min*min;
    }
}