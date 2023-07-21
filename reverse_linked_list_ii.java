class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode temp = dummy;
        for (int i = 1; i < left; i++) {
            if (temp == null) return head; // left position out of bounds
            temp = temp.next;
        }

        ListNode prev = temp.next;
        ListNode cur = prev.next;
        for (int i = left; i < right; i++) {
            if (cur == null) break; // right position out of bounds
            ListNode nex = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nex;
        }

        temp.next.next = cur;
        temp.next = prev;

        return dummy.next;
    }
}
