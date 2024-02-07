class GfG {
    int findDist(Node root, int a, int b) {
        Node lca = fun(root, a, b);
        
        return depth(lca, a) + depth(lca, b);
    }
    
    static int depth(Node node, int num){
        if(node == null) return (int)1e9;
        if(node.data == num) return 0;
        
        int left = 1 + depth(node.left, num);
        int right = 1 + depth(node.right, num);
        
        return Math.min(left, right);
    }
    
    static Node fun(Node node, int n1, int n2){
	    if(node == null) return null;
	    if(node.data == n1 || node.data == n2) return node;
	    
	    Node left = fun(node.left, n1, n2);
	    Node right = fun(node.right, n1, n2);
	    
	    if(left != null && right != null) return node;
	    if(left != null) return left;
	    if(right != null) return right;
	    
	    return null;
	}
}