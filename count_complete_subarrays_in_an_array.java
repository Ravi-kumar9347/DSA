class Solution {
    public int countCompleteSubarrays(int[] nums) {
        //O(N)
        //S(N)
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);
        int distinctElements = set.size();
        Map<Integer, Integer> counter = new HashMap<>();
        int count = 0, left = 0, right = 0;

        while(right < n){
            counter.put(nums[right], counter.getOrDefault(nums[right], 0) + 1);
            while(counter.size() == distinctElements){
                counter.put(nums[left], counter.get(nums[left]) - 1);
                if(counter.get(nums[left]) == 0){
                    counter.remove(nums[left]);
                }
                left++;
                count += n - right;
            }
            right++;
        }

        return count;
    }
}