class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j]==word.charAt(0)){
                    if(existHelper(board, word, 0, i, j, "", new HashSet<>())) return true;
                }
            }
        } 
        return false;
    }

    private boolean existHelper(char[][] board, String word, int pos, int h, int v, String res, HashSet<String> visited){
        if (h < 0 || h >= board.length || v < 0 || v >= board[h].length) return false;
        if (visited.contains(h + ";" + v) || board[h][v] != word.charAt(pos)) return false;
        String currentRes = res+board[h][v];
        if (currentRes.length() == word.length()) return true;;
        visited.add(h+";"+v);
        boolean found= existHelper(board, word, pos+1, h, v+1, currentRes, visited) ||
        existHelper(board, word, pos+1, h+1, v, currentRes, visited) ||
        existHelper(board, word, pos+1, h, v-1, currentRes, visited) ||
        existHelper(board, word, pos+1, h-1, v, currentRes, visited);
        visited.remove(h+";"+v);
        return found;
    }
}
