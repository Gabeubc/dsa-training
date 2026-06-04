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
        ListNode dummy=new ListNode();
        int len1=0;
        ListNode c1=l1;
        while(c1!=null){
            len1++;
            c1=c1.next;
        }
        int len2=0;
        ListNode c2=l2;
        while(c2!=null){
            len2++;
            c2=c2.next;
        }
        ListNode c_longest=len1>len2?l1:l2;
        ListNode c_shortest=c_longest==l1?l2:l1;
        ListNode c=dummy;
        int carry=0;
        while(c_shortest!=null || c_longest!=null){
            int o1=c_longest.val;
            int o2=c_shortest!=null?c_shortest.val:0;
            int val=o1+o2+carry;
            carry=val/10;
            val=val%10;
            c.next=new ListNode(val);
            c=c.next;
            c_longest=c_longest.next;
            c_shortest=c_shortest!=null?c_shortest.next:null;
        }
        if(carry!=0){
            c.next=new ListNode(1);
        }
        return dummy.next;
    }
}
