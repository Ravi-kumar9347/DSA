class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] visited = new int[numCourses];
        //O(n+e)
        //S(n+e)
        // Construct the graph
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int[] prereq : prerequisites) {
            graph[prereq[0]].add(prereq[1]);
        }
        
        // // Perform DFS
        // for (int i = 0; i < numCourses; i++) {
        //     if (visited[i] == 0 && !dfs(i, graph, visited)) {
        //         return false;
        //     }
        // }
        
        // return true;

        // using topological sort ->
        int indegree[] = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            for(int it : graph[i]){
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        List<Integer> topoSort = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            topoSort.add(node);

            for(int it : graph[node]){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }

        if(topoSort.size() == numCourses) return true;
        return false;
    }
    
    private boolean dfs(int course, List<Integer>[] graph, int[] visited) {
        if (visited[course] == -1) {
            return false;
        }
        if (visited[course] == 1) {
            return true;
        }
        
        visited[course] = -1;
        for (int prereq : graph[course]) {
            if (!dfs(prereq, graph, visited)) {
                return false;
            }
        }
        
        visited[course] = 1;
        return true;
    }
}
