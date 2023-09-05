class BST
{   
    //Function to find the lowest common ancestor in a BST. 
	Node LCA(Node root, int n1, int n2)
	{
	    //O(N)
	    //S(H)
        return LCAhelper(root, n1, n2);
    }
    
    private Node LCAhelper(Node node, int n1, int n2){
        if(node.data == n1 || node.data == n2) return node;
        
        if(n1 < node.data && n2 < node.data) return LCAhelper(node.left, n1, n2);
        if(n1 > node.data && n2 > node.data) return LCAhelper(node.right, n1, n2);
        
        return node;
    }
    
}