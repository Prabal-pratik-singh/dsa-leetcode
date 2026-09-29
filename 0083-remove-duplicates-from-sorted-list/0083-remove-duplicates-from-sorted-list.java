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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        ListNode n = head;
        while(n != null){
            while(n!= null && n.val == temp.val){
                n = n.next;
            }
            temp.next = n;
            temp = temp.next;
        }
        return head;
        
    }
}