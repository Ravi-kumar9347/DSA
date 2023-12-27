class Solution {
    public int jump(int[] nums) {
        //O(N)
        //S(1)
        int n = nums.length;
        int reach = 0, lastreach = -1, count = 0;
        for(int i = 0; i < n; i++){
            if(reach >= n - 1) return count;

            if(lastreach >= i && reach < i + nums[i]){
                reach = i + nums[i];
            }
            else if(reach < i + nums[i]){
                lastreach = reach;
                reach = i + nums[i];
                count++;
            }
        }

        return count;
    }
}