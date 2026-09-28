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
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null ){
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        fast =fast.next.next;
        while( fast != null && fast.next != null){
            fast = fast.next.next;
            slow =slow.next;  
        }
        
       // slow = slow.next.next;
        ListNode t1 = slow.next.next;
        ListNode t2 = new ListNode(-1);
        ListNode ans = t2;
        ListNode temp = head;
        t2.next = head;
        while(t2.next != slow.next){
            t2.next = temp;
            t2 = t2.next;
            temp = temp.next;
        } 
        t2.next = t1;
         return ans.next;
        
    }
   
}