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
        boolean remain=false;
        while(c_shortest!=null){
            int o1=c_longest.val;
            int o2=c_shortest.val;
            int val=o1+o2;
            if(remain){
                val+=1;
            }
            if(val>=10){
                val-=10;
                remain=true;
            }else{
                remain=false;
            }
            c.next=new ListNode(val);
            c=c.next;
            c_longest=c_longest.next;
            c_shortest=c_shortest.next;
        }
        while(c_longest!=null){
            int val=c_longest.val;
            if(remain){
                val+=1;
            }
            if(val>=10){
                val-=10;
                remain=true;
            }else{
                remain=false;
            }
            c.next=new ListNode(val);
            c=c.next;
            c_longest=c_longest.next;
        }
        if(remain){
            c.next=new ListNode(1);
        }
        return dummy.next;
    }
}
