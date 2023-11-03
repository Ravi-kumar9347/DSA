
class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        //O(V + E)
        //S(V)
        ArrayList<Integer> list = new ArrayList<>();
        int[] vis = new int[V];
        for(int i = 0; i < V; i++){
            if(vis[i] == 0){
                dfs(i, adj, vis, list);
            }
        }
        return list;
    }
    
    static void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, ArrayList<Integer> list){
        vis[node] = 1;
        list.add(node);
        for(int it : adj.get(node)){
            if(vis[it] == 0){
                dfs(it, adj, vis, list);
            }
        }
    }
}