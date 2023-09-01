class Tree
{
    public static void printCorner(Node node)
    {
        //O(N)
        //S(number of nodes in a level)
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        
        while(!q.isEmpty()){
            int s = q.size();
            for(int i = 1; i <= s; i++){
                Node n = q.remove();
                if(i == 1 || i == s){
                    System.out.print(n.data + " ");
                }
                
                if(n.left != null) q.add(n.left);
                
                if(n.right != null) q.add(n.right);
            }
        }
    }
    
}