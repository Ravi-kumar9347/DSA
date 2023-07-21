class Solution
{
    public static Node reverse(Node head, int k)
    {
        if (head == null || k <= 1) {
            return head;
        }

        Node dummy = new Node(0);
        dummy.next = head;
        Node prevGroupEnd = dummy;

        while (head != null) {
            Node currentGroupStart = head;
            Node prev = null;
            int count = 0;

            // Reverse the current group of k nodes
            while (head != null && count < k) {
                Node nextNode = head.next;
                head.next = prev;
                prev = head;
                head = nextNode;
                count++;
            }

            // Update pointers of the previous and current group
            prevGroupEnd.next = prev;
            prevGroupEnd = currentGroupStart;
        }

        return dummy.next;
    }
}
