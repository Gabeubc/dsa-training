class Solution {

    class Trie{

        TrieNode root;
        static class TrieNode{
            TrieNode[] nodes=new TrieNode[26];
            boolean isEnd;
        }

        Trie(){
            this.root=new TrieNode();
        }

        void insert(String word){
            char[] wordArr=word.toCharArray();
            TrieNode curr=this.root;
            for(char c: wordArr){
                int index=c-'a';
                if(curr.nodes[index]==null) curr.nodes[index]=new TrieNode();
                curr=curr.nodes[index];
            }
            curr.isEnd=true;
        }

    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie=new Trie();
        Set<String> res=new HashSet<>();
        for(String word: words) trie.insert(word);
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                findWord(board, trie.root, "", res, i, j);
            }
        } 
        return new ArrayList<>(res);
    }

    private void findWord(char[][] board, Trie.TrieNode root, String str, Set<String> res, int i, int j){
        if(Math.min(i, j)<0 || i>=board.length || j>=board[0].length || board[i][j]=='#') return;
        char c=board[i][j];
        int index=c-'a';
        if(root.nodes[index]==null) return;
        root=root.nodes[index];
        str+=c;
        if(root.isEnd) res.add(str);
        board[i][j]='#';
        findWord(board, root, str, res, i+1, j);
        findWord(board, root, str, res, i, j+1);
        findWord(board, root, str, res, i-1, j);
        findWord(board, root, str, res, i, j-1);
        board[i][j]=c;
    }
}
