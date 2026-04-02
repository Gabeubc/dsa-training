class WordDictionary {
    Node root;
    class Node{
        boolean isEnd;
        Node[] nodes=new Node[26];
        Node(){}
    }
        

    public WordDictionary() {
        this.root=new Node();
    }

    public void addWord(String word) {
        char[] wordArr=word.toCharArray();
        Node curr=this.root;
        for(int i=0; i<word.length(); i++){
            char c=word.charAt(i);
            int index=c-'a';
            if(curr.nodes[index]==null){
                Node node=new Node();
                curr.nodes[index]=node;
            }
            curr=curr.nodes[c-'a'];
        }
        curr.isEnd=true;
    }

    public boolean search(String word) {
        return searchDFS(root, word, 0);
    }

    public boolean searchDFS(Node root, String word, int pos){
        if(root==null) return false;
        if(pos==word.length()) return root.isEnd;
        char c=word.charAt(pos);
        if(c=='.'){
            for(int i=0; i<26; i++){
                if(searchDFS(root.nodes[i], word, pos+1)) return true;
            }
            return false;
        }else {
            return searchDFS(root.nodes[c-'a'], word, pos+1);
        }
    }
}
