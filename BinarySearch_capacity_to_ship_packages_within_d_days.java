class Solution {

    private static int max(int[] weights){
        int maxi = -1;
        for(int weight : weights){
            maxi = Math.max(maxi, weight);
        }
        return maxi;
    }

    private static int sum(int[] weights){
        int total = 0;
        for(int weight : weights){
            total += weight;
        }
        return total;
    }

    private static boolean isValid(int mid, int[] weights, int days){
        int minWeight = 0;
        int minDays = 0;
        for(int weight : weights){
            if(minWeight + weight <= mid){
                minWeight += weight;
            }
            else{
                minDays++;
                minWeight = weight;
            }
        }
        minDays++;
        if(minDays <= days) return true;
        return false;
    }

    public int shipWithinDays(int[] weights, int days) {
        //O(N * log(sum(weights[]) – max(weights[]) + 1))
        //S(1)
        int low = max(weights), high = sum(weights);
        while(low <= high){
            int mid = (low + high) / 2;
            if(isValid(mid, weights, days)){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
}