class Solution {

    List<Integer> eventualSafeNodes(int n, List<List<Integer>> adj) {
        //O(V+E)
        //S(3V)
        int vis[] = new int[n];
        int pathVis[] = new int[n];
        int checkNode[] = new int[n];
        for(int i=0; i<n; i++){
            if(vis[i] == 0){
                dfs(i, adj, vis, pathVis, checkNode);
            }
        }
        List<Integer> safeNodes = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(checkNode[i] == 1) safeNodes.add(i);
        }
        return safeNodes;
    }
    
    private boolean dfs(int node, List<List<Integer>> adj, int[] vis, int[] pathVis, int[] checkNode){
        vis[node] = 1;
        pathVis[node] = 1;
        checkNode[node] = 0;

        for(int adjNode : adj.get(node)){
            if(vis[adjNode] == 0){
                if(dfs(adjNode, adj, vis, pathVis, checkNode)){
                    return true;
                }
            }
            else if(pathVis[adjNode] == 1){
                return true;
            }
        }
        pathVis[node] = 0;
        checkNode[node] = 1;
        return false;
    }
}
