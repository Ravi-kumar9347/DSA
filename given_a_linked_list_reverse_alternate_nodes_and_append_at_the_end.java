class Solution
{
    public static void rearrange(Node odd)
    {
        //O(N)
        //S(1)
        if(odd.next == null || odd.next.next == null) return;
        
        Node pre = null;
        while(odd.next != null && odd.next.next != null){
            Node cur = odd.next;
            odd.next = cur.next;
            cur.next = pre;
            pre = cur;
            odd = odd.next;
        }
        
        if(odd.next == null) odd.next = pre;
        else odd.next.next = pre;
        
    }
}