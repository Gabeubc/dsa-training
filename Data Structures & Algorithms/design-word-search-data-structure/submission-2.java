class WordDictionary {

    TrieNode root;

    static class TrieNode{
        boolean isEnd;
        TrieNode[] nodes=new TrieNode[26];
    }

    public WordDictionary() {
        this.root=new TrieNode();
    }

    public void addWord(String word) {
        char[] wordArr=word.toCharArray();
        TrieNode curr=this.root;
        for(char c:wordArr){
            int i=c-'a';
            if(curr.nodes[i]==null) curr.nodes[i]=new TrieNode();
            curr=curr.nodes[i];
        }
        curr.isEnd=true;
    }

    public boolean search(String word) {
        return searchDFSHelper(this.root, word, 0);
    }

    public boolean searchDFSHelper(TrieNode curr, String word, int pos){
        if(curr==null) return false;
        if(pos==word.length()) return curr.isEnd;
        char c=word.charAt(pos);
        if(c=='.'){
            for(int i=0; i<26; i++){
                if(searchDFSHelper(curr.nodes[i], word, pos+1))
                    return true;
            }
            return false;
        }else{
            return searchDFSHelper(curr.nodes[c-'a'], word, pos+1);
        }
    }
}
