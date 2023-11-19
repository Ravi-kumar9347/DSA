class Solution
{
   public static Node findIntersection(Node head1, Node head2)
    {
        //O(N) + O(M)
        //S(N)
        HashMap<Integer, Integer> map = new HashMap<>();
        while(head1 != null){
            map.put(head1.data, map.getOrDefault(head1.data, 0) + 1);
            head1 = head1.next;
        }
        
        Node dummy = new Node(0), temp = dummy;
        while(head2 != null){
            if(map.containsKey(head2.data)){
                Node t = new Node(head2.data);
                temp.next = t;
                temp = temp.next;
                map.put(head2.data, map.get(head2.data) - 1);
                if(map.get(head2.data) == 0){
                    map.remove(head2.data);
                }
            }
            head2 = head2.next;
        }
        
        return dummy.next;
    }
}