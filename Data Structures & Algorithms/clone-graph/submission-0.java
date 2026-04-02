/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    public Node cloneGraph(Node node) {
        if(node==null)  return null;
        Deque<Node> q=new ArrayDeque<>();
        HashMap<Integer, Node> map=new HashMap<>();
        map.put(node.val, new Node(node.val));
        q.addLast(node);
        while(q.size()!=0){
            Node curr=q.removeFirst();
            for(Node n:curr.neighbors){
                if(!map.containsKey(n.val)){
                    map.put(n.val, new Node(n.val));
                    q.addLast(n);
                }
                map.get(curr.val).neighbors.add(map.get(n.val));
            }
        }
        return map.get(node.val);
    }

}