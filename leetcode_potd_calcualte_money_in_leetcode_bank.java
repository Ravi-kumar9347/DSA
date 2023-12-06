class Solution {
    public int totalMoney(int n) {
        //O(n/7)
        //S(1)
        // int week = n / 7;
        // int ans = 0, weekVal = 28;
        // for(int i = 1; i <= week; i++){
        //     ans += weekVal;
        //     weekVal += 7;
        // }
        // int day = n % 7, dayVal = week + 1;
        // for(int i = 1; i <= day; i++){
        //     ans += dayVal;
        //     dayVal++;
        // }

        // return ans;

        //O(1)
        //S(1)
        int k = n / 7;
        int sum = (k * (2 * 28 + (k-1) * 7) ) / 2;
        for(int day = 0; day < n % 7; day++){
            sum += (k+1) + day;
        }
        return sum;
    }
}