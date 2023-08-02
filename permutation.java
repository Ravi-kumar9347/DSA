class Solution {
    public void recurPermute(int index,int []nums,List<List<Integer>> ans ){
        if(index==nums.length){
            List<Integer> ds = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
        }
        for(int i=index;i<nums.length;i++){
            swap(i,index,nums);
            recurPermute(index+1,nums,ans);
            swap(i,index,nums);
        }
    }
    public void swap(int i,int j,int[]nums){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public List<List<Integer>> permute(int[] nums) {
        //O(n! * n)
        //S(1)
        List<List<Integer>> ans = new ArrayList<>();
        // recurPermute(0,nums,ans);

        //O(N!)
        backtrack(nums, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int[] nums, List<Integer> currentPermutation, List<List<Integer>> result) {
        if (currentPermutation.size() == nums.length) {
            result.add(new ArrayList<>(currentPermutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (currentPermutation.contains(nums[i])) {
                continue; // Skip elements that are already in the current permutation
            }

            currentPermutation.add(nums[i]);
            backtrack(nums, currentPermutation, result);
            currentPermutation.remove(currentPermutation.size() - 1); // Backtrack (undo the addition)
        }
    }
}