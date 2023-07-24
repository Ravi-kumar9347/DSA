class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;
        int[] base = new int[n];
        for (int i = 0; i < n - 1; i++) {
            base[i] = i + 1;
        }
        base[n - 1] = n - 1;

        Arrays.sort(nums);
        Arrays.sort(base);

        return Arrays.equals(nums, base);
    }
}
