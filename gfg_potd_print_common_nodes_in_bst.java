class Solution
{
    //Function to find the nodes that are common in both BST.
	public static ArrayList<Integer> findCommon(Node root1,Node root2)
    {
        //O(N1 + N2)
        //S(H1 + H2)
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        
        while(true){
            if(root1 != null){
                s1.push(root1);
                root1 = root1.left;
            }
            else if(root2 != null){
                s2.push(root2);
                root2 = root2.left;
            }
            else if(s1.size() > 0 && s2.size() >0){
                root1 = s1.peek();
                root2 = s2.peek();
                
                if(root1.data == root2.data){
                    result.add(root1.data);
                    s1.pop();
                    s2.pop();
                    
                    root1 = root1.right;
                    root2 = root2.right;
                }
                else if(root1.data < root2.data){
                    s1.pop();
                    root1 = root1.right;
                    root2 = null;
                }
                else{
                    s2.pop();
                    root2 = root2.right;
                    root1 = null;
                }
            }
            else{
                break;
            }
        }
        
        return result;
    }
}