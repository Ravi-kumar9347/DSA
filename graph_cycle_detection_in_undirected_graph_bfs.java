import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class Solution {
    static class Graph {
        boolean detectCycle(int V, List<List<Integer>> adj) {
            //O(V+E)
            //S(V)
            int[] vis = new int[V];
            Queue<int[]> q = new LinkedList<>();
            for (int i = 0; i < V; i++) {
                if (vis[i] == 0) {
                    int[] startPair = { i, -1 };
                    q.add(startPair);
                    vis[i] = 1;
                    while (!q.isEmpty()) {
                        int[] currentPair = q.poll(); // Renamed to currentPair
                        int node = currentPair[0];
                        int parent = currentPair[1];
                        for (int adjNode : adj.get(node)) {
                            if (vis[adjNode] == 0) {
                                vis[adjNode] = 1;
                                int[] newPair = { adjNode, node }; // Renamed to newPair
                                q.add(newPair);
                            } else if (adjNode != parent) {
                                return true;
                            }
                        }
                    }
                }
            }

            return false;

        }
    }
}
