import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution {

	public static int minimumSpanningTree(ArrayList<ArrayList<Integer>> edges, int n) {
		//O(ElogE)
		//S(E) + S(N)
		ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
		for(int i = 0; i < n; i++){
			adj.add(new ArrayList<>());
		}

		for(ArrayList<Integer> edge : edges){
			adj.get(edge.get(0)).add(new int[]{edge.get(1), edge.get(2)});
			adj.get(edge.get(1)).add(new int[]{edge.get(0), edge.get(2)});
		}

		int[] vis = new int[n];
		PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> a[0] - b[0]);
		pq.add(new int[]{0, 0});

		int sum = 0;
		while(!pq.isEmpty()){
			int[] cur = pq.poll();
			int w = cur[0], v = cur[1];

			if(vis[v] == 1) continue;
			vis[v] = 1;
			sum += w;
			for(int[] adjNode : adj.get(v)){
				if(vis[adjNode[0]] == 0){
					pq.add(new int[]{adjNode[1], adjNode[0]});
				}
			}
		}

		return sum;
	}
}