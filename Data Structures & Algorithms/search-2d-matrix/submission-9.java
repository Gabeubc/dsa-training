class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l=0;
        int R=matrix.length;
        int C=matrix[0].length;
        int r=(R*C)-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            int col=mid%C;
            int row=mid/C;
            if(matrix[row][col]==target){
                return true;
            }else if(matrix[row][col]<target){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return false;
    }
}
