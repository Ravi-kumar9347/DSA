class Solution {
    public int findChampion(int n, int[][] edges) {
        // ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        // for (int i = 0; i < n; i++) { // Use len instead of n here
        //     adj.add(new ArrayList<>());
        // }
        // for (int[] edge : edges) {
        //     adj.get(edge[0]).add(edge[1]);
        // }
        // int[] vis = new int[n]; // Use len instead of n here
        // boolean[] champ = new boolean[n]; // Use len instead of n here
        // Arrays.fill(champ, true);
        // for (int i = 0; i < n; i++) {
        //     if (vis[i] == 0) {
        //         dfs(i, adj, vis, champ);
        //     }
        // }
        // int c = 0, ind = -1;
        // for (int i = 0; i < n; i++) {
        //     if (champ[i] == true) {
        //         c++;
        //         ind = i;
        //     }
        //     if (c >= 2) {
        //         return -1;
        //     }
        // }
        // return ind;
        
        //O(N)
        //S(N)
        int[] cnt = new int[n];

        for (int[] v : edges) {
            cnt[v[1]]++;
        }

        int ans = -1;
        int x = 0;

        for (int i = 0; i < n; i++) {
            if (cnt[i] == 0) {
                ans = i;
                x++;
            }
        }

        if (x == 1) return ans;
        return -1;
    }

    // private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, boolean[] champ) {
    //     vis[node] = 1;
    //     for (int it : adj.get(node)) {
    //         if (vis[it] == 0) {
    //             champ[it] = false;
    //             dfs(it, adj, vis, champ);
    //         } else if (vis[it] == 1) {
    //             champ[it] = false;
    //         }
    //     }
    // }
}
