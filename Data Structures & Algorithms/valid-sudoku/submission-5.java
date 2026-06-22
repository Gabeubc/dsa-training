class Solution {
    public boolean isValidSudoku(char[][] board) {
        int c_len=board[0].length;
        int r_len=board.length;
        for(int i=0; i<r_len; i+=3){
            for(int j=0; j<c_len; j+=3){
                Set<Character> set=new HashSet<>();
                for(int k=i; k<i+3; k++){
                    for(int l=j; l<j+3; l++){
                        char val=board[k][l];
                        if(set.contains(val)) return false;
                        if(val!='.') set.add(board[k][l]);
                    }
                }
            }
        }
        for(int i=0; i<r_len; i++){
            Set<Character> r_set=new HashSet<>();
            Set<Character> c_set=new HashSet<>();
            for(int j=0; j<c_len; j++){
                char r_val=board[i][j];
                char c_val=board[j][i];
                if(r_set.contains(r_val)) return false;
                if(c_set.contains(c_val)) return false;
                if(r_val!='.') r_set.add(r_val);
                if(c_val!='.') c_set.add(c_val);
            }
        }
        return true;
    }
}
