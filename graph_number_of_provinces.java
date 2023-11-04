class Solution {
    public int findCircleNum(int[][] roads) {
        // O(V + E)
        // S(V)
        int V = roads.length;
        int[] vis = new int[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i == j) continue;
                if (roads[i][j] == 1) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                count++;
                dfs(i, adj, vis);
            }
        }
        return count;
    }

    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis) {
        vis[node] = 1;
        for (int it : adj.get(node)) {
            if (vis[it] == 0) {
                dfs(it, adj, vis);
            }
        }
    }
}