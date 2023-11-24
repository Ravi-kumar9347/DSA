class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //O(V+E)
        //S(V)
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for(int[] prerequisite : prerequisites){
            adj.get(prerequisite[1]).add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int[] result = new int[numCourses];
        int k = 0;
        while(!q.isEmpty()){
            int node = q.peek();
            q.poll();
            result[k++] = node;
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] != 0){
                return new int[0];
            }
        }
        return result;
    }
}