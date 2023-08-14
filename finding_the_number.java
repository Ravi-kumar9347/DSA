class Solution
{
    public int[] singleNumber(int[] nums)
    {
        //O(N)
        //S(1)
        int xorResult = 0;
        for (int num : nums) {
            xorResult ^= num;
        }

        // Find the rightmost bit where the two distinct numbers differ
        int diffBit = (xorResult & (xorResult - 1)) ^ xorResult;

        // Separate the elements into two groups based on the diffBit
        int group1 = 0;
        int group2 = 0;
        for (int num : nums) {
            if ((num & diffBit) != 0) {
                group1 ^= num;
            } else {
                group2 ^= num;
            }
        }

        return new int[] { Math.min(group1, group2), Math.max(group1, group2) };
    }
}