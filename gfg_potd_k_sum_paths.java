
class Solution
{
    int count = 0;

    public int sumK(Node root, int k) {
        //O(N)
        //S(N)
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); // Initialize with 0 sum, count = 1 (empty path)

        dfs(root, 0, k, prefixSumCount);

        return count;
    }

    private void dfs(Node node, int currentSum, int k, Map<Integer, Integer> prefixSumCount) {
        if (node == null) {
            return;
        }

        currentSum += node.data;

        // Check if there is a prefix sum in the map that makes the current sum equal to k
        count += prefixSumCount.getOrDefault(currentSum - k, 0);

        // Update the map with the current prefix sum
        prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);

        // Recursively explore left and right subtrees
        dfs(node.left, currentSum, k, prefixSumCount);
        dfs(node.right, currentSum, k, prefixSumCount);

        // Backtrack: Remove the current prefix sum to avoid affecting other paths
        prefixSumCount.put(currentSum, prefixSumCount.get(currentSum) - 1);
    }
}