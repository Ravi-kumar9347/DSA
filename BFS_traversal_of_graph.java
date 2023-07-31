class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        //O(V+E)
        //S(V)
        // Create a boolean array to track visited nodes.
        boolean[] visited = new boolean[V];

        // Create a queue for BFS traversal.
        Queue<Integer> queue = new LinkedList<>();

        // Create an ArrayList to store the BFS traversal result.
        ArrayList<Integer> bfsTraversal = new ArrayList<>();

        // Start BFS from vertex 0.
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            bfsTraversal.add(node);

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        return bfsTraversal;
    }
}