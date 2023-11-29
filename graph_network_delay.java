class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //O(N+E)
        //S(E)
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] time : times){
            adj.get(time[0]).add(new int[]{time[1], time[2]});
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(k);

        while(!q.isEmpty()){
            int curStation = q.poll();
            for(int[] adjStation : adj.get(curStation)){
                int nextStation = adjStation[0], nextDist = adjStation[1];
                if(dist[curStation] + nextDist < dist[nextStation]){
                    dist[nextStation] = dist[curStation] + nextDist;
                    q.add(nextStation);
                }
            }
        }

        int totalTime = 0;
        for(int i = 1; i <= n; i++){
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }
            totalTime = Math.max(totalTime, dist[i]);
        }
        return totalTime;
    }
}