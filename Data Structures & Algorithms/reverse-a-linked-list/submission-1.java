

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null) return head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode after = curr;
        ListNode newHead = null;
        while(curr!=null){
            if(curr.next==null){
                newHead=curr;
            }
            after=curr.next;
            curr.next=prev;
            prev=curr;
            curr=after;
        }
        return newHead;
    }
}
