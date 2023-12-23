
class Solution
{
    static int timer = 1;
    static void dfs(int node, int parent, int[] vis, int[] time, int[] lowTime, int[] mark, ArrayList<ArrayList<Integer>> adj){
        vis[node] = 1;
        time[node] = lowTime[node] = timer;
        timer++;
        int child = 0;
        for(int it : adj.get(node)){
            if(vis[it] == 0){
                dfs(it, node, vis, time, lowTime, mark, adj);
                lowTime[node] = Math.min(lowTime[node], lowTime[it]);
                if(lowTime[it] >= time[node] && parent != -1){
                    mark[node] = 1;
                }
                child++;
            }
            else{
                lowTime[node] = Math.min(lowTime[node], time[it]);
            }
        }
        
        if(child > 1 && parent == -1){
            mark[node] = 1;
        }
    }
    //Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> articulationPoints(int v,ArrayList<ArrayList<Integer>> adj)
    {
        //O(V+2E)
        //S(N)
        int[] vis = new int[v];
        int[] time = new int[v];
        int[] lowTime = new int[v];
        int[] mark = new int[v];
        for(int i = 0; i < v; i++){
            if(vis[i] == 0){
                dfs(i, -1, vis, time, lowTime, mark, adj);
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < v; i++){
            if(mark[i] == 1){
                result.add(i);
            }
        }
        
        if(result.size() == 0){
            result.add(-1);
        }
        
        return result;
    }
}