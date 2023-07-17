class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        ListNode temp = l1;
        while(temp != null){
            s1.push(temp.val);
            temp = temp.next;
        }
        temp = l2;
        while(temp != null){
            s2.push(temp.val);
            temp = temp.next;
        }
        
        ListNode cur = null;
        ListNode prev = null;
        int carry = 0, sum = 0, num = 0;
        while(!s1.isEmpty() || !s2.isEmpty()){
            sum = carry;
            if(!s1.isEmpty()){
                sum += s1.pop();
            }
            if(!s2.isEmpty()){
                sum += s2.pop();
            }
            carry = sum / 10;
            num = sum % 10;
            
            cur = new ListNode(num);
            cur.next = prev;
            prev = cur;
        }
        if(carry != 0){
            cur = new ListNode(carry);
            cur.next = prev;
            prev = cur;
        }

        return prev;
    }
}