class Solution {
    // Function to insert a node in a BST.
    Node insert(Node root, int key) {
        //O(H)
        //S(1)
        Node newNode = new Node(key);
        
        // If the tree is empty, the new node becomes the root
        if (root == null) {
            return newNode;
        }
        
        Node current = root;
        Node parent = null;
        
        while (current != null) {
            parent = current;
            
            // If the key is less than the current node's value, move left
            if (key < current.data) {
                current = current.left;
            }
            // If the key is greater than the current node's value, move right
            else if (key > current.data) {
                current = current.right;
            }
            // If the key is already in the tree, return the original root
            else {
                return root;
            }
        }
        
        // Insert the new node as the left or right child of the parent
        if (key < parent.data) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
        
        return root;
    }
}