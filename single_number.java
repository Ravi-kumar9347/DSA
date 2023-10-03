class Solution {
    public int singleNumber(int[] nums) {
        //O(N)
        //S(1)
        int number = 0;
        for(int num : nums) number ^= num;
        return number;
    }
}