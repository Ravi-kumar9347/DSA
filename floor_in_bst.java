class Solution {
    public static int floor(Node root, int x) {
        //O(N)
        //S(1)
        int val = -1;
        while(root != null){
            if(root.data == x) return x;
            if(root.data < x){
                val = root.data;
                root = root.right;
            }
            else{
                root = root.left;
            }
        }
        
        return val;
    }
}