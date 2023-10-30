
class Solution{
    public String cyclicTree(int n, int edges[][]){
        //O(N)
        //S(N)
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // Create the adjacency list
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // Check node degrees
        for (int i = 1; i <= n; i++) {
            if (adj.get(i).size() != 2) {
                return "Yes"; // A node has a degree other than 2
            }
        }

        return "No"; // All nodes have a degree of 2
    }
    
}