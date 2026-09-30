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
        ListNode prev = null;
        ListNode n = head;
        ListNode temp = head; 
        while(n != null){
            while(n!= null && n.val == temp.val){
                n = n.next;
            }

            //if there is no duplicate
            if(temp.next == n){
                prev = temp;
                temp = n;
               // temp = temp.next;
                continue;

            }
            

            //if there is duplicate
            //head
            if(prev == null){
                head = n;
               // temp = head ;
              //  prev = head;
            }
            //prev = head;
            //temp = n;

            else{
                prev.next = n;
            }
            temp = n;
        }
        return head;
        
    }
}