import java.util.ArrayList;
import java.util.Arrays;
public class Solution {
    public static int[] shortestPathInDAG(int n, int m, int [][]edges) {
        //O(V+E)
        //S(E)
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int[] temp = {edge[1], edge[2]};
            adj.get(edge[0]).add(temp);
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        dfs(0, dist, adj);
        for(int i = 0; i < n; i++){
            if(dist[i] == Integer.MAX_VALUE){
                dist[i] = -1;
            }
        }
        return dist;
    }

    private static void dfs(int node, int[] dist, ArrayList<ArrayList<int[]>> adj){
        for(int[] it : adj.get(node)){
            int adjNode = it[0];
            int d = it[1];
            if(dist[node] + d < dist[adjNode]){
                dist[adjNode] = dist[node] + d;
            }
            dfs(adjNode, dist, adj);
        }
    }
}