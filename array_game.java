
class Solution {
    public static int min_operations(int n, int[] arr, int[] brr) {
        // code here
        //O(N*N)
        //S(N)
        Queue<Integer> q = new LinkedList<>();
        for(int num : arr) q.add(num);
        
        int ans = 0, j = 0;
        while(!q.isEmpty()){
            int x = q.remove();
            if(x == brr[j]){
                ans++;
                j++;
            }
            else{
                ans++;
                q.add(x);
            }
        }
        return ans;
    }
}
     