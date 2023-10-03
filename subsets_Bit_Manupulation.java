class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //O(2^N * N)
        //S(1)

        // using bit manupulation ->
        // int l = nums.length;
        // int n = (1 << l);
        // int[][] bits = new int[n][l];
        // int gap = n / 2;

        // for(int j = 0; j < l; j++){
        //     System.out.println(gap);
        //     int k = gap;
        //     for(int i = n - 1; i >= 0; i--){
        //         if(k > 0) bits[i][j] = 1;
        //         k--;
        //         if(k == gap * -1) k = gap;    
        //     }
        //     gap /= 2;
        // }

        // List<List<Integer>> result = new ArrayList<>();
        // for(int i = 0; i < n; i++){
        //     List<Integer> temp = new ArrayList<>();
        //     for(int j = 0; j < l; j++){
        //         if(bits[i][j] == 1) temp.add(nums[j]);
        //     }
        //     result.add(temp);
        // }

        // return result;


        //instead of storing the bits in dp we can check whether it is set or not using i and j ->

        int n = nums.length;
        int p = 1 << n;
        List<List<Integer>> subs = new ArrayList<>();
        
        for (int i = 0; i < p; i++) {
            List<Integer> subset = new ArrayList<>();
            
            for (int j = 0; j < n; j++) {
                if ((i >> j & 1) == 1) {
                    subset.add(nums[j]);
                }
            }
            
            subs.add(subset);
        }
        
        return subs;
    }
}