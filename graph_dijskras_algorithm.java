import java.util.List;
import java.util.PriorityQueue;
import java.util.ArrayList;
public class Solution {
    public static List<Integer> dijkstra(int[][] edges,int vertices, int m,int source){
        //O(ElogV)
        //S(E)+S(V)
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < vertices; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e : edges){
            int[] temp1 = {e[2], e[1]};
            adj.get(e[0]).add(temp1);
            int[] temp2 = {e[2], e[0]};
            adj.get(e[1]).add(temp2);
        }

        List<Integer> dist = new ArrayList<>();
        for(int i = 0; i < vertices; i++){
            dist.add(Integer.MAX_VALUE);
        }

        dist.set(source, 0);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, source});
        while(!pq.isEmpty()){
            int[] edge = pq.poll();
            int d = edge[0];
            int node = edge[1];
            for(int[] it : adj.get(node)){
                int adjNode = it[1];
                int curdist = it[0];
                if(d + curdist < dist.get(adjNode)){
                    dist.set(adjNode, d + curdist);
                    pq.add(new int[]{dist.get(adjNode), adjNode});
                }
            }
        }

        return dist;
    }
}
