
class Solution {
    // Function to pairwise swap elements of a linked list.
    // It should returns head of the modified list
    public Node pairwiseSwap(Node head)
    {
        //O(N)
        //S(1)
        // if(head == null || head.next == null) return head;
        // Node pre = head;
        // Node temp = head.next;
        
        // while(pre.next != null && pre.next.next != null){
        //     Node cur = pre.next;
        //     Node nex = cur.next;
            
        //     cur.next = pre;
        //     if(nex.next != null) pre.next = nex.next;
        //     else pre.next = nex;
            
        //     pre = nex;
        // }
        
        // if(pre.next != null){
        //     pre.next.next = pre;
        //     pre.next = null;
        // }
        
        // return temp;
        
        //recursion ->
        if(head == null || head.next == null) return head;
        
        Node temp = head.next;
        head.next = pairwiseSwap(temp.next);
        temp.next = head;
        
        return temp;
    }
} 