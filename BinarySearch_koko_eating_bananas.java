class Solution {

    private static int max(int[] piles){
        int maxi = -1;
        for(int pile : piles){
            maxi = Math.max(maxi, pile);
        }
        return maxi;
    }

    private static boolean isValid(long mid, int[] piles, int h){
        long hours = 0;
        for(int pile : piles){
            hours += (pile / mid);
            if(pile % mid != 0){
                hours++;
            }
        }
        if(hours <= h){
            return true;
        }
        return false;
    }

    public int minEatingSpeed(int[] piles, int h) {
        //O(N*Log(max(piles)))
        //S(1)
        long low = 1, high = max(piles);
        while(low <= high){
            long mid = (low + high) / 2;
            if(isValid(mid, piles, h)){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return (int)low;
    }
}