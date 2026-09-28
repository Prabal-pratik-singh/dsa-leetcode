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
    public ListNode reverse(ListNode t){
        if(t == null || t.next == null ){
            return t;
        }
        ListNode prev = null;
        ListNode current = t;
        ListNode forward = t.next;
        while(forward != null){
            current.next = prev;
            prev = current;
            current = forward;
            forward = forward.next;
        }
        current.next = prev;
        return current;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = reverse(slow.next);
        ListNode t1 = head;
        ListNode t2 = newHead;
        while(t2 != null){
            if(t1.val != t2.val){
                return false;
            }
            t1 = t1.next ;
            t2 = t2.next;
        }
    return true;
        
    }
}