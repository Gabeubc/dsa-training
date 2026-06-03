/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map=new HashMap<>();
        Node curr=head;
        Node dummy=new Node(0);
        Node curr1=dummy;
        while(curr!=null){
            curr1.next=new Node(curr.val);
            map.put(curr, curr1.next);
            curr=curr.next;
            curr1=curr1.next;
        }
        curr=head;
        while(curr!=null){
            Node tmp=map.get(curr);
            tmp.random=map.get(curr.random);
            curr=curr.next;
        }
        return dummy.next;
    }
}
