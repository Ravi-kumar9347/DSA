class Solution {
    public int countPairs(List<Integer> nums, int target) {
        //O(NlogN)
        //S(1)
        Collections.sort(nums);
        int left = 0, right = nums.size() - 1;
        int count = 0;
        while(left < right){
            int pair = nums.get(left) + nums.get(right);
            if(pair >= target){
                right--;
            }
            else{
                count += right - left;
                left++;
            }
        }
        return count;
    }
}