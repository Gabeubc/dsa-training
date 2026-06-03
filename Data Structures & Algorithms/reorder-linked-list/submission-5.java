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
    public void reorderList(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode secondHalf=slow.next;
        slow.next=null;
        ListNode prev=null;
        ListNode curr=secondHalf;
        while(curr!=null){
            ListNode after=curr.next;
            curr.next=prev;
            prev=curr;
            curr=after;
        }
        secondHalf=prev;
        ListNode curr1=head;
        ListNode curr2=secondHalf;
        while(curr1!=null && curr2!=null){
            ListNode tmp1=curr1.next;
            ListNode tmp2=curr2.next;
            curr1.next=curr2;
            curr2.next=tmp1;
            curr1=tmp1;
            curr2=tmp2;
        }
    }
}
