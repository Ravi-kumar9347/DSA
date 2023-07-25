class Solution {
    public long maxArrayValue(int[] nums) {
        //O(N)
        //S(N)
        int n = nums.length;
        Stack<Long> st = new Stack<>();
        st.push((long)nums[n-1]);
        
        for(int i = n - 2; i >= 0; i--){
            long num =(long) nums[i];
            while(!st.isEmpty() && st.peek() >= num){
                num += st.pop();
            }
            st.push(num);
        }
        long result = 0;
        while(!st.isEmpty()){
            result = Math.max(result, st.pop());
        }
        return result;
    }
}