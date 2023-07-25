class Spiral
{
    //Function to return a list containing the level order 
    //traversal in spiral form.	
    ArrayList<Integer> findSpiral(Node root) 
    {
        //O(N)
        //S(N)
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        ArrayList<Integer> result = new ArrayList<>();
        int level = 1;
        
        while(!q.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int s = q.size();
            for(int i = 0; i < s; i++){
                Node node = q.peek();
                q.remove();
                temp.add(node.data);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            if(level % 2 == 1) Collections.reverse(temp);
            result.addAll(temp);
            level++;
        }
        
        return result;
    }
}