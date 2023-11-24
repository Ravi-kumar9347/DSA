import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class Solution {

    public static List<Integer> topologicalSort(int[][] edges, int e, int v) {
        //O(V+E)
        //S(V)
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[v];
        for(int i = 0; i < v; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < v; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        List<Integer> topologicalList = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.peek();
            q.poll();
            topologicalList.add(node);
            
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }

        return topologicalList;
    }

}