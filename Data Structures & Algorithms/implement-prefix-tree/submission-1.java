class PrefixTree {

    Node root;

    class Node{
        char c;
        boolean isEnd;
        Node[] nodes=new Node[26];
        Node(){}
    }

    public PrefixTree() {
         root=new Node();
    }

    public void insert(String word) {
        char[] wordArr=word.toCharArray();
        Node curr=this.root;
        for(char c: wordArr){
            if(curr.nodes[c-'a']==null){
                Node node=new Node();
                node.c=c;
                node.isEnd=false;
                curr.nodes[c-'a']=node;
            }
            curr=curr.nodes[c-'a'];
        }
        curr.isEnd=true;
    }

    public boolean search(String word) {
        char[] wordArr=word.toCharArray();
        Node curr=this.root;
        for(char c: wordArr){
            if(curr.nodes[c-'a']==null){
                return false;
            }
            curr=curr.nodes[c-'a'];
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        char[] prefixArr=prefix.toCharArray();
        Node curr=this.root;
        for(char c:prefixArr){
            if(curr.nodes[c-'a']==null){
                return false;
            }
            curr=curr.nodes[c-'a'];
        }
        return true;
    }
}
