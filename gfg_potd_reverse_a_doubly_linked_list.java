public static Node reverseDLL(Node  head)
{
    //O(N)
    //S(1)
    if(head.next == null) return head;
    Node cur = head.next, pre = head;
    while(cur != null){
        Node nxt = cur.next;
        cur.next = pre;
        pre.prev = cur;
        pre = cur;
        cur = nxt;
    }
    head.next = null;
    pre.prev = null;
    return pre;
}
