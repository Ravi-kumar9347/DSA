import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static int[] shortestPath(int n, int [][]edges, int src) {
        //O(V+2E)
        //S(E)
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        dfs(src, dist, adj);
        for(int i = 0; i < n; i++){
            if(dist[i] == Integer.MAX_VALUE){
                dist[i] = -1;
            }
        }
        return dist;
    }

    private static void dfs(int node, int[] dist, ArrayList<ArrayList<Integer>> adj){
        for(int it : adj.get(node)){
            if(dist[node] + 1 < dist[it]){
                dist[it] = 1 + dist[node];
                dfs(it, dist, adj);
            }
        }
    }
}