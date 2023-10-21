class GfG {
    int median(Node root, int k) {
        //O(N)
        //S(N)
        ArrayList<Node> list = new ArrayList<>();
        inorder(root, list);
        
        Node node = list.get(k - 1);

        ArrayList<Node> median = new ArrayList<>();
        
        inorder(node, median);
        
        int size = median.size();
        
        if(size % 2 == 1){
            return median.get(size / 2).data;
        }
        
        Node one = median.get(size / 2);
        Node two = median.get((size / 2) - 1 );
        
        return (one.data + two.data) / 2;
    }
    
    private static void inorder(Node root, ArrayList<Node> list){
        if(root == null) return;
        
        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
    }
    
    
    //O(N)
    //S(1)
    
    // int median(Node root, int k) {
    //     Node kthNode = findKthNode(root, k);
        
    //     if (kthNode == null) {
    //         return -1; // Handle the case where k is out of range.
    //     }
        
    //     if (k % 2 == 1) {
    //         return kthNode.data;
    //     }
        
    //     Node nextKthNode = findKthNode(root, k + 1);
        
    //     if (nextKthNode == null) {
    //         return -1; // Handle the case where k+1 is out of range.
    //     }
        
    //     return (kthNode.data + nextKthNode.data) / 2;
    // }
    
    // private static Node findKthNode(Node root, int k) {
    //     if (root == null) {
    //         return null;
    //     }
        
    //     int leftSubtreeSize = countNodes(root.left);
        
    //     if (k == leftSubtreeSize + 1) {
    //         return root;
    //     } else if (k <= leftSubtreeSize) {
    //         return findKthNode(root.left, k);
    //     } else {
    //         return findKthNode(root.right, k - leftSubtreeSize - 1);
    //     }
    // }
    
    // private static int countNodes(Node root) {
    //     if (root == null) {
    //         return 0;
    //     }
    //     return 1 + countNodes(root.left) + countNodes(root.right);
    // }

}

