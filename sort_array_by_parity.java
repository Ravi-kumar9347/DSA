class Solution {
    public int[] sortArrayByParity(int[] nums) {
        //O(N)
        //S(1)
        int n = nums.length;
        int j = n - 1, i = 0;
        int[] result = new int[n];

        for(int num : nums){
            if(num % 2 == 0) result[i++] = num;
            else result[j--] = num;
        }

        return result;
    }
}