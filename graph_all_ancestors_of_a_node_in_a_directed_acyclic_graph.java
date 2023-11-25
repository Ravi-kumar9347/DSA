class Solution {
        public List<List<Integer>> getAncestors(int n, int[][] edges) {
        //O(V+E)
        //S(V+E)
        // Build graph, and compute in degree.
        int[] inDegree = new int[n];
        Map<Integer, List<Integer>> parentToKids = new HashMap<>();
        for (int[] e : edges) {
            parentToKids.computeIfAbsent(e[0], l -> new ArrayList<>()).add(e[1]);
            ++inDegree[e[1]];
        }
        
        // 1. Use a list of sets to save ancestors 
        // and to avoid duplicates.
        // 2. Use a Queue to save 0-in-degree nodes as
        // the starting nodes for topological sort.
        List<Set<Integer>> sets = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            sets.add(new HashSet<>());
            if (inDegree[i] == 0)
                q.offer(i);
        }
        
        // BFS to their neighbors and decrease 
        // the in degrees, when reaching 0, add
        // it into queue;
        // During this procedure, get direct parent, add 
        // all ancestors of direct parents' of each kid.
        while (!q.isEmpty()) {
            int parent = q.poll();
            for (int kid : parentToKids.getOrDefault(parent, Arrays.asList())) {
                sets.get(kid).add(parent);
                sets.get(kid).addAll(sets.get(parent));
                if (--inDegree[kid] == 0)
                    q.offer(kid);
            }
        }
        
        // Sort ancestors and put into return list. 
        List<List<Integer>> ans = new ArrayList<>();
        for (Set<Integer> set : sets)
            ans.add(new ArrayList<>(new TreeSet<>(set)));
        return ans;
    }
}