class Solution {
    private static int timeOfInsertions = 1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        //O(V+2E)
        //S(3V) + S(V+2E)
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(List<Integer> connection : connections){
            adj.get(connection.get(0)).add(connection.get(1));
            adj.get(connection.get(1)).add(connection.get(0));
        }

        int[] vis = new int[n];
        int[] time = new int[n];
        int[] lowTime = new int[n];
        List<List<Integer>> result = new ArrayList<>();

        
        dfs(0, -1, vis, time, lowTime, adj, result);

        return result;
    }

    private static void dfs(int node, int parent, int[] vis, int[] time, int[] lowTime, ArrayList<ArrayList<Integer>> adj, List<List<Integer>> result){
        vis[node] = 1;
        time[node] = timeOfInsertions;
        lowTime[node] = timeOfInsertions;
        timeOfInsertions++;

        for(int it : adj.get(node)){
            if(it == parent) continue;
            if(vis[it] == 0){
                dfs(it, node, vis, time, lowTime, adj, result);
                lowTime[node] = Math.min(lowTime[node], lowTime[it]);
                if(time[node] < lowTime[it]){
                   result.add(new ArrayList<>(Arrays.asList(node, it)));
                }
            }
            else {
                lowTime[node] = Math.min(lowTime[node], lowTime[it]);
            }
        }
    }
}