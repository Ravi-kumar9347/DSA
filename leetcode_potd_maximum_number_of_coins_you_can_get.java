

class Solution {
    public int maxCoins(int[] piles) {
        //O(NlogN)
        // Integer[] pilesWrapper = Arrays.stream(piles).boxed().toArray(Integer[]::new);
        // Arrays.sort(pilesWrapper, Comparator.reverseOrder());

        // int me = 1, bob = pilesWrapper.length - 1;
        // int result = 0;

        // while (me < bob) {
        //     result += pilesWrapper[me];
        //     me += 2;
        //     bob -= 1;
        // }

        // return result;


        //O(N)
        //S(maxi)
        int n = piles.length;
        int maxi = -1;
        for(int i = 0; i < n; i++){
            maxi = Math.max(maxi, piles[i]);
        }
        int[] freq = new int[maxi + 1];
        for(int i : piles){
            freq[i]++;
        }
        int chances = n / 3;
        int turn = 1; //it is not your turn
        int result = 0, i = maxi;
        while(chances > 0){
            if(freq[i] > 0){
                if(turn == 1){
                    turn = 0;
                }
                else{
                    chances--;
                    turn = 1;
                    result += i;
                }
                freq[i]--;
            }
            else{
                i--;
            }
        }
        return result;
    }
}