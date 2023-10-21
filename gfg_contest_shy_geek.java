class Solution{
    static Shop shop;
    Solution(Shop shop){
        this.shop = shop;
    }
    static long find(int n, long k){
        // Return the number of chocolates Geek had
        // enjoyed out of 'n' chocolates availabe in the
        // 'shop'.
        //O(logN)
        //S(1)
        int high = n - 1;
        long ans = 0;

        while (k > 0) {
            int low = 0;
            long val = -1;
            while (low <= high) {
                int mid = (low + high) / 2;
                long c = shop.get(mid);
                if (c <= k) {
                    val = c;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            if (val < 0) {
                return ans;
            }

            ans += (k / val);
            k = k % val;
        }

        return ans;
 
    }

}