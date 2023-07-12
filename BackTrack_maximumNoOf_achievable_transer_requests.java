class Solution {
    public int maximumRequests(int n, int[][] requests) {
        int[] vis = new int[n];
        
        return fun(0, requests, vis, n, 0);
    }

    private static int fun(int start, int[][] requests, int[] vis, int n, int count){
        if(start == requests.length){
            for(int i = 0; i < n; i++){
                if(vis[i] != 0) return 0;
            }
            return count;
        }

        //take
        vis[requests[start][0]]--;
        vis[requests[start][1]]++;

        int take = fun(start + 1, requests, vis, n, count + 1);

        //not take
        vis[requests[start][0]]++;
        vis[requests[start][1]]--;

        int nontake = fun(start + 1, requests, vis, n, count);

        return Math.max(take, nontake);
    }
}