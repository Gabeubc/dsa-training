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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        ListNode d=new ListNode();
        ListNode res=d;
        int k=0;
        while(true){
            k=0;
            int minIndex=0;
            int min=Integer.MAX_VALUE;
            for(int i=0; i<lists.length; i++){
                if(lists[i]==null) k++;
                else if(min>=lists[i].val){
                        min=lists[i].val;
                        minIndex=i;
                }
            }
            if(k<lists.length){
                res.next=lists[minIndex];
                res=res.next;
                lists[minIndex]=lists[minIndex].next;
            }else{
                break;
            }
        }
        return d.next;
    }
}
