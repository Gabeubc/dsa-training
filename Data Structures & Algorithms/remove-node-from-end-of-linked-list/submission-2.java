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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev=head;
        ListNode slow=head;
        ListNode fast=slow;
        for(int i=0; i<n; i++){
            if(fast==null) return head;
            fast=fast.next;
        }
        while(fast!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next;
        }
        if(prev==slow){
            head=head.next;
        }else{
            prev.next=slow.next;
        }
        return head;
    }
}
