class Solution {

    class Trie{

        TrieNode root;

        static class TrieNode{
            boolean isEnd;
            TrieNode[] nodes=new TrieNode[26];
        }

        Trie(){
            this.root=new TrieNode();
        }

        void insert(String word){
            char[] wordArr=word.toCharArray();
            TrieNode curr=this.root;
            for(char c:wordArr){
                int i=c-'a';
                if(curr.nodes[i]==null) curr.nodes[i]=new TrieNode();
                curr=curr.nodes[i];
            }
            curr.isEnd=true;
        }

        static void search(TrieNode curr, char[][] board, int i, int j, String str, Set<String> res){
            if(Math.min(i, j)<0 || i>=board.length || j>=board[0].length || board[i][j]=='#') return;
            char c=board[i][j];
            int index=c-'a';
            if(curr.nodes[index]==null) return;
            board[i][j]='#';
            str+=c;
            curr=curr.nodes[index];
            if(curr.isEnd) res.add(str);
            search(curr, board, i, j+1, str, res);
            search(curr, board, i+1, j, str, res);
            search(curr, board, i, j-1, str, res);
            search(curr, board, i-1, j, str, res);
            board[i][j]=c;
        }

    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie=new Trie();
        Set<String> res=new HashSet<>();
        for(String word: words) trie.insert(word);
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                Trie.search(trie.root, board, i, j, "", res);
            }
        }
        return new ArrayList<>(res);
    }
}
