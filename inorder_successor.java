class Solution
{
    // returns the inorder successor of the Node x in BST (rooted at 'root')
	public Node inorderSuccessor(Node root,Node x)
        {
          //1. Brute force ->
          //Store inorder in a list and apply binary search to get next element of given node
          //O(N)+O(N)
          //S(N)
          
          //2. Do inorder traversal and find next greater element of given node(because it is sorted)
          //O(N)
          //S(1)
            
        //3. BST property ->moving left or right based on given value
        //O(H)
        //S(1)
            
            Node successor = null;
            
            while(root != null){
                if(root.data <= x.data) root = root.right;
                else{
                    successor = root;
                    root = root.left;
                }
            }
            
            return successor;
        }
        
   
}