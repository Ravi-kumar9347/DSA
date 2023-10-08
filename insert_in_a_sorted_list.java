class Solution {
    Node sortedInsert(Node head, int key) {
        //O(N)
        //S(1)
        Node nex = new Node(key);
        if(head.data >= key){
            nex.next = head;
            return nex;
        }
        
        Node temp = head;
        Node pre = null;
        
        while(temp != null && temp.data <= key){
            pre = temp;
            temp = temp.next;
        } 

        nex.next = temp;
        pre.next = nex;
        
        return head;
    }
}