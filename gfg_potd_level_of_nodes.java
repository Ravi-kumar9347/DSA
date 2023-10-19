
class Solution
{
    //Function to find the level of node X.
    int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X)
    {
        //O(V)
        //S(V)
        int[] vis = new int[V];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0));
        vis[0] = 1;
        
        while(!q.isEmpty()){
            Pair p = q.remove();
            if(p.node == X) return p.dist;
            
            for(int it : adj.get(p.node)){
                if(vis[it] == 0){
                    q.add(new Pair(it, p.dist + 1));
                    vis[it] = 1;
                }
            }
        }
        
        return -1;
    }
}

class Pair{
    int node;
    int dist;
    Pair(int node, int dist){
        this.node = node;
        this.dist = dist;
    }
}