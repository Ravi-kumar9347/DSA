class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        //O(N)
        //S(K)

        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        int size = count / k;
        int rem = count % k;
        ListNode[] parts = new ListNode[k];
        temp = head;
        int i = 0;
        while (temp != null) {
            ListNode dummy = new ListNode(0);
            ListNode current = dummy;
            int c = 0;
            while (temp != null && c < size) {
                current.next = temp;
                temp = temp.next;
                current = current.next;
                c++;
            }
            if (rem > 0) {
                current.next = temp;
                temp = temp.next;
                current = current.next;
                rem--;
            }
            current.next = null; // End the current list
            parts[i] = dummy.next; // Assign the head of the current list to parts[i]
            i++;
        }
        return parts;
    }
} 
