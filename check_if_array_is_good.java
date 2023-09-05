class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        
        for(int i = 1; i < n; i++){
            set.add(i);
        }
        
        int size = 0;
        int lastNum = 0;
        for(int i = 0; i < n; i++){
            if(set.contains(nums[i])){
                size++;
                if(nums[i] == n - 1){
                    lastNum++;
                }
            }
        }
        
        return (size == n && lastNum == 2) ? true : false;
    }
}