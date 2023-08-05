class Solution {
    private static int findGCD(int num1, int num2) {
        //O(log(min(num1, num2)))
        if (num2 == 0) {
            return num1;
        }
        return findGCD(num2, num1 % num2);
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        //O(Nlog(min(num1, num2))) //S(1)
        if(head.next == null) return head;
        
        ListNode cur = head;
        ListNode nex = head.next;
        while(nex != null){
            int gcd = findGCD(cur.val, nex.val);
            ListNode temp = new ListNode(gcd);
            cur.next = temp;
            temp.next = nex;
            cur = nex;
            nex = nex.next;
        }
        
        return head;
    }
}