import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public static List<Integer> topologicalSort(int[][] edges, int e, int v) {
        //O(V+E)
        //S(V)
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < v; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
        }

        int[] vis = new int[v];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < v; i++){
            if(vis[i] == 0){
                dfs(i, vis, adj, st);
            }
        }

        List<Integer> topologicalList = new ArrayList<>();
        while(!st.isEmpty()){
            topologicalList.add(st.pop());
        }

        return topologicalList;
    }

    static void dfs(int node, int[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st){
        vis[node] = 1;
        for(int it : adj.get(node)){
            if(vis[it] == 0){
                dfs(it, vis, adj, st);
            }
        }

        st.push(node);
    }
}