
class Solution{
    public int isEulerCircuit(int v, List<Integer>[] adj) 
    {
        //O(V)
        //S(1)
        //eluer circuit -> for all v nodes -> have even no.of edges
        //eluer path -> 2 nodes must have only one edge , remaining v-2 nodes have even no.of edges
        int count = 0;
        for (int i = 0; i < v; i++) {
            if(adj[i].size() % 2 == 0) count++;
        }
        
        if(count == v) return 2;
        if(count == v-2) return 1;
        return 0;
        
    }
}