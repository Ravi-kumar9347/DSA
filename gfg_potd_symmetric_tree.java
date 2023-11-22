class GfG
{
    // return true/false denoting whether the tree is Symmetric or not
    public static boolean isSymmetric(Node root)
    {
        // if(root == null) return true;
        // // return fun(root.left, root.right);
        
        //O(N)
        //S(H)
        if (root == null) return true;

        Stack<Node> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
    
        while (!stack.isEmpty()) {
            Node n1 = stack.pop();
            Node n2 = stack.pop();
    
            if (n1 == null && n2 == null) continue;
            if (n1 == null || n2 == null || n1.data != n2.data) return false;
    
            stack.push(n1.left);
            stack.push(n2.right);
            stack.push(n1.right);
            stack.push(n2.left);
        }
    
        return true;
    }
    
    private static boolean fun(Node l, Node r){
        if(l == null && r == null) return true;
        if((l == null && r != null) || (l != null && r == null) || (l.data != r.data)) return false;
        
        return fun(l.left, r.right) && fun(l.right, r.left);
    }
}