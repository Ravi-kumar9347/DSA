class Solution{
    public int getCount(Node node, int bud)
    {
        //O(N)
        //S(N)
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        int level = 1, count = 0;
        while(bud > 0 && !q.isEmpty()){
            int s = q.size();
            for(int i = 0; i < s; i++){
                Node n = q.remove();
                
                if(n.left == null && n.right == null && bud - level >= 0){
                    bud -= level;
                    count++;
                } 
                
                if(n.left != null) q.add(n.left);
                if(n.right != null) q.add(n.right);
            }
            level++;
        }
        return count;
    }
}