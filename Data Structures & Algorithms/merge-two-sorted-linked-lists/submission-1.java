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
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode res= null;
        if(list1.val>list2.val){
            res=new ListNode(list2.val);
            list2=list2.next;
        }else{
            res=new ListNode(list1.val);
            list1=list1.next;
        }
        ListNode currRes=res;
        ListNode curr1=list1;
        ListNode curr2=list2;
        while(curr1!=null && curr2!=null){
            if(curr1.val>curr2.val){
                currRes.next=curr2;
                currRes=currRes.next;
                curr2=curr2.next;
            }else{
                currRes.next=curr1;
                currRes=currRes.next;
                curr1=curr1.next;
            }
        }
        if(curr2!=null && curr1==null){
            currRes.next=curr2;
        }
        if(curr1!=null && curr2==null){
            currRes.next=curr1;
        }
        return res;
    }
}