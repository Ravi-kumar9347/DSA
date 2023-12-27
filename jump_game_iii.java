class Solution {
    public boolean canReach(int[] arr, int start) {
        //O(N)
        //S(N)
        int n = arr.length;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        int[] vis = new int[n];
        while(!q.isEmpty()){
            int cur = q.poll();
            vis[cur] = 1;
            if(arr[cur] == 0) return true;

            if(isValid(cur - arr[cur], n, vis)){
                q.add(cur - arr[cur]);
            } 
            if(isValid(cur + arr[cur], n, vis)){
                q.add(cur + arr[cur]);
            } 
        }

        return false;
    }

    static boolean isValid(int num, int n, int[] vis){
        if(num >= 0 && num < n && vis[num] == 0) return true;
        return false;
    }
}