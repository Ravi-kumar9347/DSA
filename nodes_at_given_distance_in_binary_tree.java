class Solution
{
    //O(NlogN)
    //S(N)
    
    private static void findParent(Node node, Map<Node, Node> parents){
        if(node.left != null){
            parents.put(node.left, node);
            findParent(node.left, parents);
        }
        
        if(node.right != null){
            parents.put(node.right, node);
            findParent(node.right, parents);
        }    
        
        return;
    }
    
    private static Node findNode(Node node, int target) {
        if (node == null) {
            return null;
        }
    
        if (node.data == target) {
            return node;
        }
    
        // Recursively search in the left subtree
        Node leftResult = findNode(node.left, target);
        
        if (leftResult != null) {
            return leftResult; // If found in the left subtree, return it
        }

        // If not found in the left subtree, search in the right subtree
        return findNode(node.right, target);
    }

    
    public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k)
    {
        Map<Node, Node> parents = new HashMap<>();
        parents.put(root, null);
        findParent(root, parents);
        
        Queue<Node> q = new LinkedList<>();
        Node node = findNode(root, target);
        q.add(node);
        HashSet<Node> set = new HashSet<>();
        set.add(node);
        
        while(k > 0){
            int s = q.size();
            for(int i = 0; i < s; i++){
                Node n = q.poll();
                if(n.left != null && !set.contains(n.left)){
                    q.add(n.left);
                    set.add(n.left);
                }
                
                if(n.right != null && !set.contains(n.right)){
                    q.add(n.right);
                    set.add(n.right);
                }
                
                if(parents.get(n) != null && !set.contains(parents.get(n))){
                    q.add(parents.get(n));
                    set.add(parents.get(n));
                }
                // System.out.println(n.data);
            }
            k--;
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        while(!q.isEmpty()){
            result.add(q.poll().data);
        }
        
        Collections.sort(result);
        
        return result;
    }
};