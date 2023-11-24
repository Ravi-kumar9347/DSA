class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        //O(V+E)
        //S(V+E)
        int v = graph.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[v];
        for(int i = 0; i < v; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < v; i++){
            for(int j = 0; j < graph[i].length; j++){
                adj.get(graph[i][j]).add(i);
                indegree[i]++;
            }
            
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < v; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.peek();
            q.poll();
            safeNodes.add(node);
            
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }

        Collections.sort(safeNodes);
        return safeNodes;
    }
}

