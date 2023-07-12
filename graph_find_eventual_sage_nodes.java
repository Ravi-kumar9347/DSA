class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        //O(V+E)
        //S(3V)
        // int n = graph.length;
        // int vis[] = new int[n];
        // int pathVis[] = new int[n];
        // int checkNode[] = new int[n];
        // for(int i=0;i<n;i++){
        //     if(vis[i]==0){
        //         dfs(i,graph,vis,pathVis,checkNode);
        //     }
        // }
        // List<Integer> safeNodes = new ArrayList<>();
        // for(int i=0;i<n;i++){
        //     if(checkNode[i]==1) safeNodes.add(i);
        // }
        // return safeNodes;


        //using topological sort, bfs

        //1 -> reverse the graph
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        //caluculate indegree
        int indegree[] = new int[n];
        for(int i = 0; i < n; i++){
            for(int it : graph[i]){
                adj.get(it).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> safeNodes = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0) q.add(i);
        } 
        //start topological sort
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            safeNodes.add(node);
            for(int it : adj.get(node)){
                indegree[it]--; 
                if(indegree[it] == 0) q.add(it);
            }
        }
        Collections.sort(safeNodes);
        return safeNodes;
    }
    private boolean dfs(int node,int[][] graph,int[] vis,int[] pathVis,int[] checkNode){
        vis[node]=1;
        pathVis[node]=1;
        checkNode[node]=0;

        for(int adj:graph[node]){
            if(vis[adj]==0){
                if(dfs(adj,graph,vis,pathVis,checkNode)==true){
                    return true;
                }
            }
            else if(pathVis[adj]==1) return true;
        }
        pathVis[node]=0;
        checkNode[node]=1;
        return false;
    }
}