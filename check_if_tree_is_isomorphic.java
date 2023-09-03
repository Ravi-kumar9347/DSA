
class Solution  
{ 
    // Return True if the given trees are isomotphic. Else return False.
    boolean isIsomorphic(Node root1, Node root2)  
    { 
        //O(N)
        //S(max(H1,H2));
        if(root1 == null && root2 == null) return true;
        
        if(root1 == null || root2 == null) return false;
        
        if(root1.data != root2.data) return false;
        
        return (isIsomorphic(root1.left, root2.left) && isIsomorphic(root1.right, root2.right)) || 
                (isIsomorphic(root1.left, root2.right) && isIsomorphic(root1.right, root2.left));
        
        
        
        // if (root1 == null && root2 == null) {
        //     return true;
        // }
        // if (root1 == null || root2 == null) {
        //     return false;
        // }

        // Queue<Node> queue1 = new LinkedList<>();
        // Queue<Node> queue2 = new LinkedList<>();

        // queue1.add(root1);
        // queue2.add(root2);

        // while (!queue1.isEmpty() && !queue2.isEmpty()) {
        //     int size1 = queue1.size();
        //     int size2 = queue2.size();

        //     if (size1 != size2) {
        //         return false;
        //     }

        //     for (int i = 0; i < size1; i++) {
        //         Node node1 = queue1.poll();
        //         Node node2 = queue2.poll();

        //         if (node1.data != node2.data) {
        //             return false;
        //         }

        //         // Compare the structures of left and right subtrees
        //         if ((node1.left != null && node2.left != null) || (node1.left == null && node2.left == null)) {
        //             if (node1.left != null) {
        //                 queue1.add(node1.left);
        //                 queue2.add(node2.left);
        //             }
        //         } else {
        //             return false;
        //         }

        //         if ((node1.right != null && node2.right != null) || (node1.right == null && node2.right == null)) {
        //             if (node1.right != null) {
        //                 queue1.add(node1.right);
        //                 queue2.add(node2.right);
        //             }
        //         } else {
        //             return false;
        //         }
        //     }
        // }

        // return true;
    }
    
}    