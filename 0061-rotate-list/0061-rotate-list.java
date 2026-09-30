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

    ListNode findkth(ListNode head,int n){
        ListNode temp = head;
        while(n != 0){
            temp = temp.next;
            n--;
        }
        return temp;
    }


    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
    return head;
}
        ListNode tail = head;
        ListNode temp = head;
        int length = 1;
        while(tail.next != null){
            tail = tail.next;
            length++;
        }

        if(k%length == 0 ){
            return head;
        }
        k= k%length;
        tail.next = head;
        int n = length - k-1;
        ListNode kth = findkth(head,n);
        ListNode newn = kth.next;
        kth.next = null;


        return newn;
        

        

        
        
    }
}