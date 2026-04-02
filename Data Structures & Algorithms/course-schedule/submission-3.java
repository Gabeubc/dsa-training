class Solution {
    record Node(int course, List<Node> neighbors){}
    int remainingCourses=0;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Node> nodes=buildGraph(prerequisites);
        for(Node node: nodes.values()){
            remainingCourses=numCourses;
            if(!dfs(node, new HashSet<>())) return false;
        }
        return true;
    }

    private boolean dfs(Node node, Set<Integer> visited){
        if(visited.contains(node.course)) return false;
        remainingCourses--;
        visited.add(node.course);
        for(Node neighbor: node.neighbors){
            if(!dfs(neighbor, visited)) return false;
            visited.remove(neighbor.course);
        }
        return true;
    }

    private HashMap<Integer, Node> buildGraph(int[][] prerequisites){
        HashMap<Integer, Node> nodes=new HashMap<>();
        int r=prerequisites.length;
        for(int i=0; i<r; i++){
            int[] prerequisite=prerequisites[i];
            if(!nodes.containsKey(prerequisite[0])){
                nodes.put(prerequisite[0], new Node(prerequisite[0], new ArrayList<>()));
            }
            if(!nodes.containsKey(prerequisite[1])){
                nodes.put(prerequisite[1], new Node(prerequisite[1], new ArrayList<>()));
            }
            nodes.get(prerequisite[1]).neighbors.add(nodes.get(prerequisite[0]));
        }
        return nodes;
    }
}
