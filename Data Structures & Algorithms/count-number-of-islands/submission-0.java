class Solution {

    public int numIslands(char[][] grid) {
        int res=0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]=='1'){
                    numIslandsHelper(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void numIslandsHelper(char[][] grid, int i, int j){
        if((Math.min(i,j)<0 || i>=grid.length || j>=grid[0].length) || grid[i][j]=='0') return;
        grid[i][j]='0';
        numIslandsHelper(grid, i, j+1);
        numIslandsHelper(grid, i+1, j);
        numIslandsHelper(grid, i, j-1);
        numIslandsHelper(grid, i-1, j);
    }
}
