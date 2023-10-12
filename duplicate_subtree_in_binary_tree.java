class Solution {
    
    private static String solve(Node root, Map<String, Integer> map){
        if(root == null) return "$";
        StringBuilder s = new StringBuilder();
        
        if(root.left == null && root.right == null){
            return s.append(root.data).toString(); // Append the integer value to the StringBuilder
        }
        s.append(root.data); // Append the integer value to the StringBuilder
        s.append(solve(root.left, map)); // Append the result of solve for the left subtree
        s.append(solve(root.right, map)); // Append the result of solve for the right subtree
        
        String result = s.toString(); // Convert the StringBuilder to a String
        map.put(result, map.getOrDefault(result, 0) + 1);
        return result;
    }
    
    int dupSub(Node root) {
        //O(N)
        //S(N)
        Map<String, Integer> map = new HashMap<>();
        
        solve(root, map);
        
        for(Integer value : map.values()){
            if(value >= 2) return 1;
        }
        
        return 0;
    }
}
