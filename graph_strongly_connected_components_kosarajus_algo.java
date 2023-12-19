class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int v, ArrayList<ArrayList<Integer>> adj)
    {
        //O(V+E)
        //S(V+E)
        
        //sort all the edeges of their finishing time
        Stack<Integer> s = new Stack<>();
        int[] vis = new int[v];
        for(int i = 0; i < v; i++){
            if(vis[i] == 0){
                dfssort(i, adj, vis, s);
            }
        }
        
        //reverse graph
        ArrayList<ArrayList<Integer>> adjRev = new ArrayList<>();
        for(int i = 0; i < v; i++){
            adjRev.add(new ArrayList<>());
        }
        
        for(int i = 0; i < v; i++){
            for(int j = 0; j < adj.get(i).size(); j++){
                adjRev.get(adj.get(i).get(j)).add(i);
            }
        }
        
        //do dfs
        Arrays.fill(vis, 0);
        int scc = 0;
        while(!s.isEmpty()){
            int node = s.peek();
            s.pop();
            if(vis[node] == 0){
                dfs(node, adjRev, vis);
                scc++;
            }
        }
        
        return scc;
    }
    
    private static void dfssort(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, Stack<Integer> s){
        vis[node] = 1;
        for(int it : adj.get(node)){
            if(vis[it] == 0){
                dfssort(it, adj, vis, s);
            }
        }
        
        s.push(node);
    }
    
    
    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis){
        vis[node] = 1;
        for(int it : adj.get(node)){
            if(vis[it] == 0){
                dfs(it, adj, vis);
            }
        }
    }
}