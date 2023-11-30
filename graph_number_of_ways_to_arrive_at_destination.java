
class Solution {
    public int countPaths(int n, int[][] roads) {
        //O(ElogV)
        //S(E)+S(V)
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            adj.get(road[0]).add(new int[]{road[1], road[2]});
            adj.get(road[1]).add(new int[]{road[0], road[2]});
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE); 
        int[] paths = new int[n];
        paths[0] = 1;
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.add(new long[]{0, 0});
        dist[0] = 0;
        int mod = (int) 1e9 + 7;

        while (!pq.isEmpty()) {
            long[] road = pq.poll();
            int curRoad = (int) road[1];
            long curDist = road[0]; 

            for (int[] adjRoad : adj.get(curRoad)) {
                int nextRoad = adjRoad[0], nextDist = adjRoad[1];
                if (curDist + nextDist < dist[nextRoad]) {
                    dist[nextRoad] = curDist + nextDist;
                    paths[nextRoad] = paths[curRoad];
                    pq.add(new long[]{dist[nextRoad], nextRoad});
                } else if (curDist + nextDist == dist[nextRoad]) {
                    paths[nextRoad] = (int) ((paths[nextRoad] + paths[curRoad]) % mod);
                }
            }
        }

        return paths[n - 1];
    }
}
