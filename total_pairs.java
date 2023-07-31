
class Solution
{
    //O(N logN)
//S(1)
    private int upperBound(int[] a, int target, int start, int end) {
        int l = start, h = end, ans = -1;

        while(l <= h) {
            int mid = l + (h-l)/2;

            if(a[mid]>=target) {
                ans= mid;
                h = mid-1;
            } else {
                l= mid+1;
            } 
        }
        
        return ans;
    }
    
    private int lowerBound(int[] a, int target, int start, int end) {
        int l = start, h = end, ans = -1;

        while(l <= h) {
            int mid = l + (h-l)/2;

            //smallest index such that arr[i] >= target
            if(a[mid] <= target){
                ans= mid;
                l= mid+1;
            } else{
                h= mid-1;
            }
        }

        return ans;
    }
    
    
    public int TotalPairs(int[] nums, int x, int y)
    {
        // Code here 
        int count = 0, n=nums.length;
        Arrays.sort(nums);
        
        for(int i = 0; i < n; i++) {
            int lowerMultiple = (x+nums[i]-1)/nums[i];//(formula for finding ceil)
            int higherMultiple = y / nums[i];//floor value
            
            int s = upperBound(nums, lowerMultiple, i+1, n-1); //from next i+1 index will search, value greater or equal than lowerMultiple, will be returning index of that
            int e = lowerBound(nums, higherMultiple, i+1, n-1);//from next i+1 index will search, value next smaller or equal than higherMultiple, will be returning index of that
            //as value multiple of nums[i] i.e. nums[j] lies in this range (nums[i] *nums[j])
           // System.out.println("nums[i]" + nums[i] + " ,s:" + s+ ", e:" +e);
            if(s<=e && s!=-1 && e!=-1)
                count += e - s+1;
        }
        
        return count;
    }
}

