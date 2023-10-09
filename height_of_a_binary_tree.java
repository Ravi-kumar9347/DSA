class Solution {
    //Function to find the height of a binary tree.
    int height(Node node) 
    {
        //O(N)
        //S(N) stack space
        if(node == null) return 0;
        
        int left = 1 + height(node.left);
        int right = 1 + height(node.right);
        
        return Math.max(left, right);
    }
}