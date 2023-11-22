import java.util.ArrayList;

public class Solution 
{
    public static Boolean isCyclic(int[][] edges, int v, int e)
    {
        //O(V+E)
        //S(V)
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < v; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
        }
        
        int[] vis = new int[v];
        int[] pathVis = new int[v];
        for(int i = 0; i < v; i++){
            if(vis[i] == 0){
                if(dfs(i, vis, pathVis, adj) == true){
                    return true;
                }
            }
        }

        return false;
	}

    static boolean dfs(int node, int[] vis, int[] pathVis, ArrayList<ArrayList<Integer>> adj){
        vis[node] = 1;
        pathVis[node] = 1;
        for(int it : adj.get(node)){
            if(vis[it] == 0){
                if(dfs(it, vis, pathVis, adj) == true){
                    return true;
                }
            }
            else if(pathVis[it] == 1){
                return true;
            }
        }

        pathVis[node] = 0;
        return false;
    }
}