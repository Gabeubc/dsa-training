class Solution {

    record Node(
        int val,
        List<Node> neighbors
    ){}

    Set<Integer> visited=new HashSet<>();

    public int countComponents(int n, int[][] edges) {
        Map<Integer, Node> graph=buildGraph(edges);
        int res=0;
        for(Node root:graph.values()){
            if(!visited.contains(root.val)){
                res++;
                dfs(root, null);
            }
        }
        return res+(n-visited.size());
    }
    private void dfs(Node root, Node start){
        if(visited.contains(root.val)) return;
        visited.add(root.val);
        for(Node neighbor: root.neighbors){
            if(start==null || (start!=null && root.val!=start.val)) dfs(neighbor, root);
        }
    }
    private Map<Integer, Node> buildGraph(int[][] edges){
        Map<Integer, Node> graph=new HashMap<>();
        for(int[] edge:edges){
            addIfNotExist(graph, edge);
            addNeighbors(graph, edge);
        }
        return graph;
    }
    private void addIfNotExist(Map<Integer, Node> graph, int[] edge){
        if(!graph.containsKey(edge[0])) graph.put(edge[0], new Node(edge[0], new LinkedList<>()));
        if(!graph.containsKey(edge[1])) graph.put(edge[1], new Node(edge[1], new LinkedList<>()));
    }
    private void addNeighbors(Map<Integer, Node> graph, int[] edge){
        graph.get(edge[0]).neighbors.add(graph.get(edge[1]));
        graph.get(edge[1]).neighbors.add(graph.get(edge[0]));
    }
}
