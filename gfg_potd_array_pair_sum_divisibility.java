class Solution {
    public boolean canPair(int[] nums, int k) {
        //O(N)
        //S(N)
        int n = nums.length;
        if(n % 2 != 0) return false;
    
        int[] arr = new int[k];
        for(int i = 0; i < n; i++){
            arr[nums[i] % k]++;
        }
        
        int i = 1, j = k - 1;
        if(arr[0] % 2 == 1) return false;
        while(i <= j){
            if(arr[i] != arr[j]) return false;
            i++;
            j--;
        }
        
        return true;
    }
}
