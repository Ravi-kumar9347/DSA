class Solution {
    public boolean find132pattern(int[] nums) {
        //O(N)
        //S(N)
        int n = nums.length;
        Stack<Integer> s = new Stack<>();
        int third = Integer.MIN_VALUE;

        for(int i = n - 1; i >= 0; i--){
            if(nums[i] < third) return true;
            //[i, s, third]
            while(!s.isEmpty() && nums[i] > s.peek()){
                third = s.pop();
            }
            s.push(nums[i]);
        }

        return false;
    }
}

// import java.util.Stack;

// class Solution {
//     public boolean find132pattern(int[] nums) {
//         int n = nums.length;

//         int[] minFromLeft = new int[n];
//         minFromLeft[0] = nums[0];
//         for (int i = 1; i < n; i++) {
//             minFromLeft[i] = Math.min(minFromLeft[i - 1], nums[i]);
//         }

//         Stack<Integer> stack = new Stack<>();

//         for (int j = n - 1; j >= 0; j--) {
//             if (nums[j] > minFromLeft[j]) {
//                 while (!stack.isEmpty() && stack.peek() <= minFromLeft[j]) {
//                     stack.pop();
//                 }
//                 if (!stack.isEmpty() && stack.peek() < nums[j]) {
//                     return true;
//                 }
//                 stack.push(nums[j]);
//             }
//         }

//         return false;
//     }
// }

