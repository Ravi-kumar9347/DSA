class Solution {

    private static int lowerBound(int []arr, int x, int n) {
        //O(logN)
        //S(1)
        int lb = n, low = 0, high = n - 1;

        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == x){
                lb = mid;
                high = mid - 1;
            }
            else if(arr[mid] > x){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return lb;
    }

    private static int upperBound(int []arr, int x, int n){
        //O(logN)
        //S(1)
        int ub = n, low = 0, high = n - 1;

        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] > x){
                ub = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return ub;
    }

    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] result = new int[2];
        int lb = lowerBound(nums, target, n);
        if(lb == n){
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        int ub = upperBound(nums, target, n);
        result[0] = lb;
        result[1] = ub - 1;
        return result;
    }
}

// class Solution {
//     public int[] searchRange(int[] nums, int target) {
//         int[]result={-1,-1};
//         int low=0,high=nums.length-1,mid;      
//         while(high>=low){
//             mid=(low+(high-low)/2);
//             if (target==nums[mid]) {
//                 result[0]=mid;
//                 high=mid-1;
//             }else if(target<nums[mid])high=mid-1;
//             else low=mid+1;
//         }
//         low=0;
//         high=nums.length-1;
//         while(high>=low){
//             mid=(low+(high-low)/2);
//             if (target==nums[mid]) {
//                 result[1]=mid;
//                 low=mid+1;
//             }else if(target<nums[mid])high=mid-1;
//             else low=mid+1;
//         }
//         return result;   
//     }
// }