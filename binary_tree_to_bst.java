
class Solution
{
    // The given root is the root of the Binary Tree
    // Return the root of the generated BST
    private void inOrderTraversal(Node root, List<Integer> nodes) {
        if (root == null)
            return;

        inOrderTraversal(root.left, nodes);
        nodes.add(root.data);
        inOrderTraversal(root.right, nodes);
    }

    // Function to convert binary tree to BST
    private Node convertToBST(List<Integer> nodes, int left, int right) {
        if (left > right)
            return null;

        int mid = left + (right - left) / 2;
        Node root = new Node(nodes.get(mid));

        root.left = convertToBST(nodes, left, mid - 1);
        root.right = convertToBST(nodes, mid + 1, right);

        return root;
    }

    public Node binaryTreeToBST(Node root) {
        //O(N logN)
        //S(N)
        if (root == null)
            return null;

        // Step 1: Perform in-order traversal and store nodes in a list
        List<Integer> nodes = new ArrayList<>();
        inOrderTraversal(root, nodes);

        // Step 2: Sort the list of nodes
        Collections.sort(nodes);

        // Step 3: Recreate the binary tree as a balanced BST
        return convertToBST(nodes, 0, nodes.size() - 1);
    }

}