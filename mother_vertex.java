
class Solution {
    // Function to find a Mother Vertex in the Graph.
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>> graph) {
        //O(V+E)
        //S(V)
        boolean[] visited = new boolean[V];
        int lastVertex = -1; // Initialize the last visited vertex to -1

        // Perform Depth-First Search (DFS) starting from each vertex
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, graph, visited);
                lastVertex = i; // Update the last visited vertex
            }
        }

        // Check if the lastVertex is a mother vertex
        Arrays.fill(visited, false);
        dfs(lastVertex, graph, visited);

        for (boolean isVisited : visited) {
            if (!isVisited) {
                return -1; // No mother vertex found
            }
        }

        return lastVertex; // Return the mother vertex
    }

    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited);
            }
        }
    }
}
