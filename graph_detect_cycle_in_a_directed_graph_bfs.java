import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class Solution {
  public static boolean detectCycleInDirectedGraph(int n, ArrayList<ArrayList<Integer>> edges) {
    // O(V+E)
    // S(V)
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    int[] indegree = new int[n+1];
    for (int i = 0; i < n+1; i++) {
      adj.add(new ArrayList<>());
    }
    for (ArrayList<Integer> edge : edges) {
      adj.get(edge.get(0)).add(edge.get(1));
      indegree[edge.get(1)]++;
    }

    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < n+1; i++) {
      if (indegree[i] == 0) {
        q.add(i);
      }
    }

    while (!q.isEmpty()) {
      int node = q.peek();
      q.poll();

      for (int it : adj.get(node)) {
        indegree[it]--;
        if (indegree[it] == 0) {
          q.add(it);
        }
      }
    }

    for(int i = 0; i < n; i++){
      if(indegree[i] != 0){
        return true;
      }
    }
    return false;
  }
}