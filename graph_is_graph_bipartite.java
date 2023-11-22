class Solution {
    public boolean isBipartite(int[][] graph) {
        //O(E) edges
        //S(N)

        int n = graph.length;
        int[] vis = new int[n];
        for(int i = 0; i < n; i++){
            if(vis[i] == 0){
                if(dfs(i, 1, vis, graph) == false){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean dfs(int node, int color, int[] vis, int[][] graph){
        vis[node] = color;
        for(int it : graph[node]){
            if(vis[it] == 0){
                if(dfs(it, color == 1 ? 2 : 1, vis, graph) == false){
                    return false;
                }
            }
            else if(vis[it] == color){
                return false;
            }
        }
        return true;
    }
}