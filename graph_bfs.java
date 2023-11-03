class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        //O(V+E)
        //S(V)
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        int[] vis = new int[V];
        q.add(0);
        vis[0] = 1;
        while(!q.isEmpty()){
            int n = q.poll();
            list.add(n);
            for(int it : adj.get(n)){
                if(vis[it] == 0){
                    vis[it] = 1;
                    q.add(it);
                }
            }
        }
        return list;
    }
}