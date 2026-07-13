class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int R=matrix.length;
        int C=matrix[0].length;
        int N=R*C;
        int l=0;
        int r=N-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            int row=mid/C;
            int col=mid%C;
            if(matrix[row][col]==target){
                return true;
            }else if(target<matrix[row][col]){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return false;
    }
}
