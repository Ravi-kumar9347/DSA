class Solution
{
    //Function to check if two trees are identical.
	boolean isIdentical(Node root1, Node root2)
	{
	    //O(N)
	    //S(H)
	    Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(root1);
        stack2.push(root2);
    
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            Node node1 = stack1.pop();
            Node node2 = stack2.pop();
    
            if (node1.data != node2.data) {
                return false;
            }
    
            if (node1.left != null && node2.left != null) {
                stack1.push(node1.left);
                stack2.push(node2.left);
            } else if (node1.left != null || node2.left != null) {
                return false;
            }
    
            if (node1.right != null && node2.right != null) {
                stack1.push(node1.right);
                stack2.push(node2.right);
            } else if (node1.right != null || node2.right != null) {
                return false;
            }
        }
    
        return true;
	   
	   //if(root1 == null && root2 == null) return true;
	   //if((root1 == null && root2 != null) || (root1 != null && root2 == null) || root1.data != root2.data){
	   //    return false;
	   //} 
	   //boolean left = isIdentical(root1.left, root2.left);
	   //boolean right = isIdentical(root1.right, root2.right);
	   //return left && right;
	}
	
	
}