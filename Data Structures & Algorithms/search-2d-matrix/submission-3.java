class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r_len=matrix.length;
        int c_len=matrix[0].length;
        int l=0;
        int r=(r_len*c_len)-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            int row=mid/c_len;
            int col=mid%c_len;
            if(target==matrix[row][col]){
                return true;
            }
            if(target<matrix[row][col]){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return false;
    }
}
