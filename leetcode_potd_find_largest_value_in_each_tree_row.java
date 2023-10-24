class Solution {
    public List<Integer> largestValues(TreeNode root) {
        //O(N)
        //S(N)
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            int maxi = Integer.MIN_VALUE;
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                maxi = Math.max(maxi, node.val);
                
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            result.add(maxi);
        }
        return result;
    }
}