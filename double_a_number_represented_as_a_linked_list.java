
// class Solution {
//     public ListNode doubleIt(ListNode head) {
//         //O(N + M) N -> no.of Nodes, M -> Length of converted number to string
//         //S(N +  M)
//         ListNode temp = head;
//         StringBuilder num = new StringBuilder();
        
//         while (temp != null) {
//             num.append(temp.val);
//             temp = temp.next;
//         }
        
//         BigInteger number = new BigInteger(num.toString());
//         number = number.multiply(BigInteger.valueOf(2));
        
//         String newNum = number.toString();
        
//         ListNode result = new ListNode(0);
//         ListNode dummy = result;
        
//         for (int i = 0; i < newNum.length(); i++) {
//             dummy.next = new ListNode(Character.getNumericValue(newNum.charAt(i)));
//             dummy = dummy.next;
//         }
        
//         return result.next;
//     }
// }
class Solution {
    public ListNode doubleIt(ListNode head) {
//O(N)
//S(1)
        if (head.val > 4)
            head = new ListNode(0, head);
        for(ListNode node = head; node != null; node = node.next) {
            node.val = (node.val * 2) % 10;
            if (node.next != null && node.next.val > 4)
                node.val++;
        }
        return head;
    }
}