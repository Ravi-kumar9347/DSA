class Solution {
    Node removeDuplicates(Node head) {
        if (head == null || head.next == null) {
            return head; // Handle empty or single-node list
        }
        
        Node temp = head;
        
        while (temp.next != null) {
            Node cur = temp;
            
            while (temp.next != null && temp.data == temp.next.data) {
                temp = temp.next;
            }
            
            if (temp.next != null) {
                Node temp2 = temp.next;
                cur.next = temp2;
                temp2.prev = cur;
                temp = temp2;
            } else {
                cur.next = null; // Reached the end, set next to null
            }
        }
        
        return head;
    }
}
