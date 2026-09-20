/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        int carry = 0;
        ListNode current = dummy;
        while(l1 != null || l2 != null){
            int val1 =0;
            int val2 = 0;
            if(l1 != null){
                 val1 = l1.val;
            }
            if(l2 != null){
                 val2 = l2.val;
            }
            int sum = val1 + val2 +carry;
            current.next = new ListNode(sum%10);
            carry = sum/10;
            current = current.next;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
          
            


        }
          if(carry != 0){
                current.next = new ListNode(carry);
            }

        return dummy.next;

        
    }
}