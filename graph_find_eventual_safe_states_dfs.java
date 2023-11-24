class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        //O(V+E)
        //S(V)
        int n = graph.length;
        int[] vis = new int[n];
        int[] pathvis = new int[n];
        int[] check = new int[n];
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(vis[i] == 0){
                dfs(i, vis, pathvis, check, graph);
            }
        }
        
        for(int i = 0; i < n; i++){
            if(check[i] == 1){
                result.add(i);
            }
        }
        return result;
    }

    private void dfs(int node, int[] vis, int[] pathvis, int[] check, int[][] graph){
        vis[node] = 1;
        pathvis[node] = 1;
        for(int it : graph[node]){
            if(vis[it] == 0){
                dfs(it, vis, pathvis, check, graph);
            }
            if(pathvis[it] != 0){
                return;
            }
        }
        check[node] = 1;
        pathvis[node] = 0;
    }
}