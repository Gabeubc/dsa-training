class PrefixTree {

    TrieNode root;

    static class TrieNode{
        boolean isEnd;
        TrieNode[] nodes=new TrieNode[26];
    }

    public PrefixTree() {
        root=new TrieNode();
    }

    public void insert(String word) {
        char[] wordArr=word.toCharArray();
        TrieNode curr=this.root;
        for(char c: wordArr){
            int i=c-'a';
            if(curr.nodes[i]==null){
                curr.nodes[i]=new TrieNode();
            }
            curr=curr.nodes[i];
        }
        curr.isEnd=true;
    }

    public boolean search(String word) {
        char[] wordArr=word.toCharArray();
        TrieNode curr=this.root;
        for(char c:wordArr){
            int i=c-'a';
            if(curr.nodes[i]==null) return false;
            curr=curr.nodes[i];
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        char[] prefixArr=prefix.toCharArray();
        TrieNode curr=this.root;
        for(char c:prefixArr){
            int i=c-'a';
            if(curr.nodes[i]==null) return false;
            curr=curr.nodes[i];
        }
        return true;
    }
}
