class Solution {
    public int candy(int[] ratings) {
        //O(N)
        //S(N)
        // int n = ratings.length;
        // int[] candies = new int[n];
        // Arrays.fill(candies, 1);

        // for(int i = 1; i < n; i++){
        //     if(ratings[i] > ratings[i-1]){
        //         candies[i] = candies[i-1] + 1;
        //     }
        // }

        // for (int i = n - 2; i >= 0; i--) {
        //     if (ratings[i] > ratings[i + 1]) {
        //         candies[i] = Math.max(candies[i], candies[i + 1] + 1);
        //     }
        // }

        // int ans = 0;
        // for(int candy : candies) ans += candy;

        // return ans;

        //O(N)
        //S(1)
        if (ratings == null || ratings.length == 0) {
            return 0;
        }

        int ret = 1, up = 0, down = 0, peak = 0;

        for (int i = 1; i < ratings.length; i++) {
            int prev = ratings[i - 1];
            int curr = ratings[i];

            if (prev < curr) {
                up = up + 1;
                down = 0;
                peak = up + 1;
                ret += 1 + up;
            } else if (prev == curr) {
                up = down = peak = 0;
                ret += 1;
            } else {
                up = 0;
                down = down + 1;
                ret += 1 + down - (peak > down ? 1 : 0);
            }
        }

        return ret;
    }
}