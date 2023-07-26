class Solution
{
    public int kthAncestor(Node root, int k, int node)
    {
        //O(N)
        //S(N)
        Map<Integer,Integer> parents = new HashMap<>();
        parents.put(root.data, -1);
        assignParents(parents, root);
        
        // for (Map.Entry<Integer, Integer> entry : parents.entrySet()) {
        //     System.out.println(entry.getKey() + " -> " + entry.getValue());
        // }
        
        int result = node;
        for(int i = 1; i <= k; i++){
            result = parents.get(result);
            if(result == -1) return -1;
        }
        return result;
    }
    private static void assignParents(Map<Integer,Integer> parents, Node root){
        if(root == null) return;
        
        if(root.left != null){
            parents.put(root.left.data, root.data);
            assignParents(parents, root.left);
        } 
        
        if(root.right != null){
            parents.put(root.right.data, root.data);
            assignParents(parents, root.right);
        }
        
        return;
    }
    

}