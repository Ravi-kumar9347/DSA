
class Solution{
    public List<List<Integer>> generateAdjacencyList(int V, int E, int edges[][]){
        //O(ElogV)
        //S(V+E)
        List<List<Integer>> adj =  new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            int from = edge[0];
            int to = edge[1];
            
            if(!adj.get(from).contains(to)){
                adj.get(from).add(to);
            }
            
            if(!adj.get(to).contains(from)){
                adj.get(to).add(from);
            }
        }
        
        for (List<Integer> neighbors : adj) {
            Collections.sort(neighbors);
        }
        
        return adj;
    }
}
