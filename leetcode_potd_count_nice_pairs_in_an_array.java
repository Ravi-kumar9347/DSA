

class Solution {
    public int countNicePairs(int[] nums) {
        //O(N)
        //S(N)
        HashMap<Integer, Long> map = new HashMap<>();
        long ans = 0;
        int mod = (int) 1e9 + 7;
        
        for (int num : nums) {
            int rev = 0, temp = num;
            while (num > 0) {
                rev = (rev * 10) + (num % 10);
                num /= 10;
            }
            
            int diff = temp - rev;
            ans = (ans + map.getOrDefault(diff, 0L)) % mod;
            map.put(diff, (map.getOrDefault(diff, 0L) + 1) % mod);
        }
        
        return (int) ans;
    }
}
