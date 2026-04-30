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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode curr1=list1;
        ListNode curr2=list2;
        ListNode dup=new ListNode();
        ListNode prev=dup;
        while(curr1!=null || curr2!=null){
            if(curr1!=null && curr2!=null){
                if(curr1.val<curr2.val){
                    dup.next=curr1;
                    curr1=curr1.next;
                }else{
                    dup.next=curr2;
                    curr2=curr2.next;
                }
            }else if(curr1!=null){
                dup.next=curr1;
                curr1=curr1.next;
            }else{
                dup.next=curr2;
                curr2=curr2.next;
            }
            dup=dup.next;
        }
        return prev.next;
    }
}