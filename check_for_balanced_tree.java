class Tree
{
    
    //Function to check whether a binary tree is balanced or not.
    boolean isBalanced(Node root)
    {
	    if(height(root) >= (int)1e7) return false;
	    return true;
    }
    //O(N)
    //S(H)
    private static int height(Node root){
        if(root == null) return 0;
        int left = 1 + height(root.left);
        int right = 1 + height(root.right);
        
        if(Math.abs(left - right) > 1) return (int)1e7;
        return Math.max(left, right);
    }
}