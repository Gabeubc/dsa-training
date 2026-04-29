class Solution {
    public int maxArea(int[] heights) {
        int len=heights.length;
        int l=0;
        int r=len-1;
        int area=0;
        while(l<r){
            area=Math.max(
                area,
                (r-l)*Math.min(heights[l], heights[r])
            );
            if(heights[l]<heights[r]) l++;
            else r--;
        }
        return area;
    }
}
