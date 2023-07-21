class Solution
{
    //Function to remove duplicates from unsorted linked list.
    public Node removeDuplicates(Node head) 
    {
        Set<Integer> set = new HashSet<>();
        Node dummy = head;
        Node cur = head;
        Node prev = null;
        while(cur != null){
            if(set.contains(cur.data)){
                prev.next = cur.next;
            }
            else{
                set.add(cur.data);
                prev = cur;
            }
            cur = cur.next;
        }
        return dummy;
    }
}
