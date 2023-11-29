class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //O(N)
        //S(E) + S(V)
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] flight : flights){
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, 0, 0});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curStation = cur[0], curStops = cur[1], curDist = cur[2];
            if(curStops > k) continue;
            for(int[] adjStation : adj.get(curStation)){
                int nextStation = adjStation[0], nextDist = adjStation[1];
                if(curDist + nextDist < dist[nextStation] && curStops <= k){
                    dist[nextStation] = curDist + nextDist;
                    q.add(new int[]{nextStation, curStops+1, dist[nextStation]});
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}