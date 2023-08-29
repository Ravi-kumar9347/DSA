
class GfG
{
    //Function to remove duplicates from sorted linked list.
    Node removeDuplicates(Node head)
    {
        //O(N)
        //S(1)
	    Node temp = head;
	    Node dummy = new Node(0);
	    Node result = dummy;
	    
	    while(temp != null){
	        while(temp.next != null && temp.data == temp.next.data){
	            temp = temp.next;
	        } 
	        
	        dummy.next = temp;
	        dummy = dummy.next;
	        temp = temp.next;
	    }
	    
	    return result.next;
    }
}