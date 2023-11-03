import java.util.ArrayList;

public class Solution {
    public static int findNumOfProvinces(int[][] roads, int V) {
        // O(V + E)
        // S(V)
        ArrayList<Integer> list = new ArrayList<>();
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
                dfs(i, adj, vis, list);
            }
        }
        return count;
    }

    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, ArrayList<Integer> list) {
        vis[node] = 1;
        list.add(node);
        for (int it : adj.get(node)) {
            if (vis[it] == 0) {
                dfs(it, adj, vis, list);
            }
        }
    }
}
