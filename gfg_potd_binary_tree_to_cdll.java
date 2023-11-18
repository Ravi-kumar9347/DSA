class Solution
{ 
    //Function to convert binary tree into circular doubly linked list.
    Node bTreeToClist(Node root)
    {
        //O(N)
        //S(H)
        Stack<Node> s = new Stack<>();
        Node pre = null;
        Node head = null;  // Track the head of the circular doubly linked list

        while (true) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }

            if (s.isEmpty())
                break;

            Node cur = s.pop();
            if (pre == null) {
                head = cur;  // If pre is null, set the head of the list
            } else {
                cur.left = pre;
                pre.right = cur;
            }
            pre = cur;
            root = cur.right;
        }

        // Make it circular
        if (head != null) {
            head.left = pre;
            pre.right = head;
        }

        return head;
    }
    
}