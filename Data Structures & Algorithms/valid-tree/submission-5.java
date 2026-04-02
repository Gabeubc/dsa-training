class Solution {

    record Node(
        int val,
        List<Node> neighbors
    ){}

    public boolean validTree(int n, int[][] edges) {
        if(edges.length==0) return true;
        Map<Integer, Node> graph=buildGraph(edges);
        Set<Integer> visited=new HashSet<>();
        Node root=graph.values().iterator().next();
        if (hasCycle(null, root, visited)) return false;
        return visited.size()==n;
    }

    private boolean hasCycle(Node root, Node node, Set<Integer> visited){
        if(visited.contains(node.val)) return true;
        visited.add(node.val);
        for(Node neighbor: node.neighbors){
            if(!(root!=null && root.val==neighbor.val) && hasCycle(node, neighbor, visited)) return true;
            
        }
        return false;
    }

    private Map<Integer, Node> buildGraph(int[][] edges){
        Map<Integer, Node> res=new HashMap<>();
        int r=edges.length;
        for(int i=0; i<r; i++){
            int[] edge=edges[i];
            addIfNotExist(edge, res);
            res.get(edge[0]).neighbors.add(res.get(edge[1]));
            res.get(edge[1]).neighbors.add(res.get(edge[0]));
        }
        return res;
    }

    private void addIfNotExist(int[] edge, Map<Integer, Node> graph){
        if(!graph.containsKey(edge[0])){
            Node node=new Node(edge[0], new LinkedList<>());
            graph.put(edge[0], node);
        }
        if(!graph.containsKey(edge[1])){
            Node node=new Node(edge[1], new LinkedList<>());
            graph.put(edge[1], node);
        }
    }
}
