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
        PriorityQueue<ListNode> heap=new PriorityQueue<>((a,b)->a.val-b.val);
        for(int i=0; i<lists.length; i++){
            ListNode curr=lists[i];
            while(curr!=null){
                heap.add(curr);
                curr=curr.next;
            }
        }
        ListNode dummy=new ListNode();
        ListNode curr=dummy;
        while(heap.size()!=0){
            ListNode item=heap.poll();
            item.next=null;
            curr.next=item;
            curr=curr.next;
        }
        return dummy.next;
    }
}
