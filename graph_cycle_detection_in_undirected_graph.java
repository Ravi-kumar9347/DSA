import java.util.List;
public class Solution {
    static class Graph {
        boolean detectCycle(int V, List<List<Integer>> adj) {
            //O(V+E)
            //S(V)
            int[] vis = new int[V];
            for (int i = 0; i < V; i++) {
                if (vis[i] == 0 && dfs(i, -1, vis, adj)) {
                    return true;
                }
            }
            return false;
        }

        static boolean dfs(int node, int parent, int[] vis, List<List<Integer>> adj) {
            vis[node] = 1;

            for (int adjNode : adj.get(node)) {
                if (vis[adjNode] == 0) {
                    if (dfs(adjNode, node, vis, adj)) {
                        return true;
                    }
                } else if (adjNode != parent) {
                    return true;
                }
            }

            return false;
        }
    }
}