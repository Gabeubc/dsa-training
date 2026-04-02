class Solution {

    record Node(
        char val,
        List<Node> neighbors
    ){}

    public String foreignDictionary(String[] words) {
        if(words.length==1) return words[0];
        Map<Character, Node> letters=buildLetters(words);
        List<Character> res=new LinkedList<>();
        Map<Character, Integer> inDegree=new HashMap<>();
        Queue<Node> queue=new LinkedList<>();
        for(Character letter: letters.keySet()) inDegree.put(letter, 0);
        for(Node node: letters.values()){
            for(Node neighbor:node.neighbors){
                inDegree.put(neighbor.val, inDegree.get(neighbor.val)+1);
            }
        }
        for(Map.Entry<Character, Integer> e: inDegree.entrySet()){
            if(e.getValue()==0) queue.add(letters.get(e.getKey()));
        }
        while(!queue.isEmpty()){
            Node curr=queue.poll();
            res.add(curr.val);
            for(Node node:curr.neighbors){
                inDegree.put(node.val, inDegree.get(node.val)-1);
                if(inDegree.get(node.val)==0){
                    queue.add(node);
                }
            }
        }
        if(res.size()!=letters.size()) return "";
        StringBuilder resBuilder=new StringBuilder();
        for(Character c:res){
            resBuilder.append(c);
        }
        return resBuilder.toString();
    }

    private Map<Character, Node> buildLetters(String[] words){
        Map<Character, Node> letters=new HashMap<>();
        final int LEN_WORDS=words.length;
        for(int i=0; i<LEN_WORDS-1;i++){
            if(words[i].length()>words[i+1].length() && words[i].startsWith(words[i+1])) continue;
            char[] word1=words[i].toCharArray();
            char[] word2=words[i+1].toCharArray();
            int j=0;
            boolean orderFound=false;
            final int longestLen=word1.length<word2.length?word2.length:word1.length;
            while(j<longestLen){
                if(j<word1.length && !letters.containsKey(word1[j])){
                    Node node=new Node(word1[j], new LinkedList<>());
                    letters.put(word1[j], node);
                }
                if(j<word2.length && !letters.containsKey(word2[j])){
                    Node node=new Node(word2[j], new LinkedList<>());
                    letters.put(word2[j], node);
                }
                if(j<word1.length && !orderFound && j<word2.length && word1[j]!=word2[j]){
                    letters.get(word1[j]).neighbors.add(letters.get(word2[j]));
                    orderFound=true;
                }
                j++;
            }
        }
        return letters;
    }
}
