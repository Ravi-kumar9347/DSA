class Solution {
    public static int count_set_bits(int arr[], int n) {
        //O(N)
        //S(1)
        int ans = 0;
        for(int num : arr){
            while(num > 0){
                int bit = num & 1;
                if(bit != 0){
                    ans++;
                }
                num = num >> 1;
            }
        }
        return ans;
    }
}