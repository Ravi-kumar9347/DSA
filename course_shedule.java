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
        
        // Perform DFS
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && !dfs(i, graph, visited)) {
                return false;
            }
        }
        
        return true;
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
