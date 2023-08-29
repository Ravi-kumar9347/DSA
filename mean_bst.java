
class Solution{
    int mean(Node root, int key){
        //O(H)
        //S(1)
        double small = -1;
        double large = -1;
        
        while(root != null){
            if(root.data == key) return key;
            
            if(root.data < key){
                small = root.data;
                root = root.right;
            }
            else{
                large = root.data;
                root = root.left;
            }
        }
        
        return (int)Math.ceil(((small + large) / 2));
    }
}