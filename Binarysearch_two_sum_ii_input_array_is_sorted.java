class Solution {
    public int[] twoSum(int[] nums, int t) {
        //O(NlogN)
        //S(1)
        int n = nums.length;
        int[] result = {-1, -1};
        for(int i = 0; i < n; i++){
            int num = t - nums[i], low = i + 1, high = n - 1, ind = -1;
            while(low <= high){
                int mid = (low + high) / 2;
                if(nums[mid] == num){
                    ind = mid;
                    break;
                }
                if(nums[mid] < num) low = mid + 1;
                else high = mid - 1;
            }
            if(ind != -1){
                result[0] = i + 1;
                result[1] = ind + 1;
                return result;
            }
        }
        return result;
    }
}

// class Solution {
//     public int[] twoSum(int[] numbers, int target) {
            //O(N)
            //S(1)
//         int[] ans = new int[2];
//         ans[0]=-1;
//         ans[1]=-1;
//         int start = 0 ,end = numbers.length - 1;
//         while(start<=end){
//             if(numbers[start] + numbers[end] == target){
//                 ans[0] = start+1;
//                 ans[1] = end+1;
//                 return ans;
//             }
//             else if(numbers[start] + numbers[end] < target) start++;
//             else end--;
//         }
//         return ans;
//     }
// }
