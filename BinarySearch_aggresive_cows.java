class Solution {

    private static boolean isValid(int mid, int[] position, int m){
        int count = 1, lastInd = -1;
        for(int i = 0; i < position.length; i++){
            if(lastInd == -1){
                lastInd = i;
            }
            else if(position[i] - position[lastInd] >= mid){
                count++;
                lastInd = i;
            }
        }
        if(count >= m) return true;
        return false;
    }

    public int maxDistance(int[] position, int m) {
        //O(NlogN)->sorting + O(Nlog(max(position) - min(position)))
        //S(1)
        int n = position.length;
        Arrays.sort(position);
        int low = 1, high = position[n - 1] - position[0];

        while(low <= high){
            int mid = (low + high) / 2;
            if(isValid(mid, position, m)){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        return high;
    }
}