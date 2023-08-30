class GfG
{
    Node deleteNode(Node head, int x)
    {
        //O(N)
        //S(1)
	    Node temp = new Node(0);
	    temp.next = head;
	    Node dummy = temp;
	    int n = 1;
	    while(n != x){
	       temp = temp.next;
	       n++;
	    } 
	    temp.next = temp.next.next;
	    return dummy.next;
    }
}