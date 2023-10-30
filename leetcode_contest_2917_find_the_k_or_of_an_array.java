class Solution {
    public int findKOr(int[] nums, int k) {
        //O(N)
        //S(N)
        int n = nums.length;
        int[][] bits = new int[n][32];
        int ans = 0;
        for(int i = 0; i < n; i++){
            int num = nums[i], j = 0;
            while(num > 0){
                bits[i][j] = (num & 1);
                // System.out.print(bits[i][j] + " ");
                num = num >> 1;
                j++;
            }
        }
        
        
        for(int bit = 0; bit < 32; bit++){
            int c = 0;
            for(int i = 0; i < n; i++){
                if(bits[i][bit] == 1){
                    c++;
                    
                }
            }
            if(c >= k){
                ans += (1 << bit);
            }
        }
        return ans;
    }
}