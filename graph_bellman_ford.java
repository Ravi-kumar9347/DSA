import java.util.List;
import java.util.Arrays;
public class Solution {
    public static int[] bellmonFord(int n, int m, int src, List<List<Integer>> edges) {
        //O(N*E)
        //S(N)
        int[] dist = new int[n+1];
        Arrays.fill(dist, (int)1e8);
        dist[src] = 0;
        for(int i = 0; i < n-1; i++){
            for(List<Integer> edge : edges){
                int u = edge.get(0), v = edge.get(1), w = edge.get(2);
                if(dist[u] + w < dist[v]) dist[v] = dist[u] + w;
            }
        }
        return dist;
    }
}
