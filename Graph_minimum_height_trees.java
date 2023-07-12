class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        //O(N) //S(N)
        if(n == 1){
            return Collections.singletonList(0);
        }

        List<Set<Integer>> adj = new ArrayList<>(n);
        for(int i = 0; i < n; i++){
            adj.add(new HashSet<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> leaves = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(adj.get(i).size() == 1){
                leaves.offer(i);
            }
        }

        int remainingLeaves = n;
        while(remainingLeaves > 2){
            int levelSize = leaves.size();
            remainingLeaves -= levelSize;

            for(int i = 0; i < levelSize; i++){
                int leaf = leaves.poll();
                int neighbor = adj.get(leaf).iterator().next();
                adj.get(neighbor).remove(leaf);

                if(adj.get(neighbor).size() == 1){
                    leaves.offer(neighbor);
                }
            }
        }

        List<Integer> roots = new ArrayList<>(leaves);
        return roots;
    }
}