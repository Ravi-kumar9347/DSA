class GfG
{
    Node buildBalancedTree(Node root) 
    {
        //O(N)
        //S(N)
        ArrayList<Integer> nodes = new ArrayList<>();
        
        inorder(root, nodes);
        
        return constructBST(nodes, 0, nodes.size() - 1);
    }
    
    private static void inorder(Node root, ArrayList<Integer> nodes){
        if(root == null) return;
        
        inorder(root.left, nodes);
        nodes.add(root.data);
        inorder(root.right, nodes);
        
        return;
    }
    
    private static Node constructBST(ArrayList<Integer> nodes, int left, int right){
        if(left > right) return null;
        
        int mid = (left + right) / 2;
        Node root = new Node(nodes.get(mid));
        
        root.left = constructBST(nodes, left, mid - 1);
        root.right = constructBST(nodes, mid + 1, right);
        
        return root;
    }
}
