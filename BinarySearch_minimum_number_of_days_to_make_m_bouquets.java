class Solution {

    private static int min(int[] bloomDay){
        int mini = (int)1e9;
        for(int day : bloomDay){
            mini = Math.min(mini, day);
        }
        return mini;
    }

    private static int max(int[] bloomDay){
        int maxi = -1;
        for(int day : bloomDay){
            maxi = Math.max(maxi, day);
        }
        return maxi;
    }

    private static boolean isValid(long mid, int m, int k, int[] bloomDay){
        int n = bloomDay.length, blooms = 0, count = 0;
        for(int i = 0; i < n; i++){
            if(bloomDay[i] <= mid){
                count++;
            }
            else{
                blooms += (count / k);
                count = 0;
            }
        }
        blooms += (count / k);
        if(blooms < m) return false;
        return true;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        //O(N * log(max(bloomDay) - min(bloomDay)))
        //S(1)
        if(bloomDay.length < (long)m * k) return -1;
        long low = min(bloomDay), high = max(bloomDay);
        
        while(low <= high){
            long mid = (low + high) / 2;
            if(isValid(mid, m, k, bloomDay)){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return (int)low;
    }
}