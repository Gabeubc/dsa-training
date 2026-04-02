class Solution {

    record Position(int i, int j){};

    boolean reachedPacific; 
    boolean reachedAtlantic;
    int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res=new ArrayList<>();
        int r=heights.length, c=heights[0].length;
        boolean[][] pacific=new boolean[r][c];
        boolean[][] antlatic=new boolean[r][c];
        for(int i=0; i<r; i++){
            dfs(heights, pacific, i, 0);
            dfs(heights, antlatic, i, c-1);
        }
        for(int i=0; i<c; i++){
            dfs(heights, pacific, 0, i);
            dfs(heights, antlatic, r-1, i);
        }
        for(int i=0; i<heights.length; i++){
            for(int j=0; j<heights[0].length; j++){
                if(pacific[i][j] && antlatic[i][j]) res.add(List.of(i,j));
            }
        }
        return res;
    }

    public void dfs(int[][] heights, boolean[][] ocean, int i, int j){
        ocean[i][j]=true;
        for(int[] d:DIRS){
            int nr=i+d[0], nc=j+d[1];
            if(nr>=0 && nc>=0 &&  
                nr<heights.length && 
                nc<heights[0].length &&
                !ocean[nr][nc] &&
                heights[i][j]<=heights[nr][nc])
                    dfs(heights, ocean, nr, nc);
        }
        return;
    }
}
