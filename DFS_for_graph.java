
class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        //O(V + E)
        //S(V)
        int[] vis = new int[V];
        ArrayList<Integer> dfsList = new ArrayList<>();
        
        for(int i = 0; i < V; i++){
            if(vis[i] == 0){
                dfs(i, adj, vis, dfsList);
            }
        }
        
        return dfsList;
    }
    
    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, ArrayList<Integer> dfsList){
        vis[node] = 1;
        dfsList.add(node);
        
        for(int it : adj.get(node)){
            if(vis[it] == 0){
                dfs(it, adj, vis, dfsList);
            }
        }
        return;
    }
}