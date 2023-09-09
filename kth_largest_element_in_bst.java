class Solution {
    //O(N)
    //S(H)
    // Create a class variable to keep track of the Kth largest element
    private int kthLargest = Integer.MIN_VALUE;

    // Create a variable to count the Kth element
    private int count = 0;

    public int kthLargest(Node root, int K) {
        // Call the recursive function to find the Kth largest element
        kthLargestUtil(root, K);

        // Return the Kth largest element
        return kthLargest;
    }

    private void kthLargestUtil(Node node, int K) {
        if (node == null || count >= K) {
            return;
        }

        // Recursively traverse the right subtree first
        kthLargestUtil(node.right, K);

        // Increment the count
        count++;

        // If count is equal to K, update kthLargest
        if (count == K) {
            kthLargest = node.data;
            return;
        }

        // Continue with the left subtree
        kthLargestUtil(node.left, K);
    }
}
