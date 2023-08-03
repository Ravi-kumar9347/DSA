class Solution {
    //Topologiical + Dijsktras
	public int[] shortestPath(int N,int M, int[][] edges) {
	    //O(N + M)
	    //S(N + M)
		List<List<int[]>> graph = new ArrayList<>();
		for(int i = 0; i < N; i++){
		    graph.add(new ArrayList<>());
		}
		for(int[] edge : edges){
		    graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
		}
		
		int[] indegree = new int[N];
		for(int[] edge : edges){
		    indegree[edge[1]]++;
		}
		
		int[] distance = new int[N];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[0] =  0;
		
		Queue<Integer> q = new LinkedList<>();
		for(int i = 0; i < N; i++){
		    if(indegree[i] == 0){
		        q.add(i);
		    }
		}
		
		while(!q.isEmpty()){
		    int current = q.poll();
		    
		    for(int[] neighbor : graph.get(current)){
		        int next = neighbor[0];
		        int weight = neighbor[1];
		        
		        if(distance[current] != Integer.MAX_VALUE && distance[current] + weight < distance[next]){
		            distance[next] = distance[current] + weight;
		        }
		        indegree[next]--;
		        
		        if(indegree[next] == 0){
		            q.add(next);
		        }
		    }
		}
		
		for(int i = 0; i < N; i++){
		    if(distance[i] == Integer.MAX_VALUE){
		        distance[i] = -1;
		    }
		}
		
		return distance;
	}
}