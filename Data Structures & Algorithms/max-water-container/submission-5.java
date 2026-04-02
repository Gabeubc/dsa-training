class Solution {
    public int maxArea(int[] heights) {
        int len=heights.length;
        int l=0;
        int r=len-1;
        int maxArea=0;
        while(l<r){
            int h=0;
            int b=r-l;
            if(heights[l]<heights[r]){
                h=heights[l];
                l++;
            }else{
                h=heights[r];
                r--;
            }
            maxArea=Math.max(maxArea, area(b, h));
        }
        return maxArea;
    }
    public int area(int b, int h){
        return b*h;
    }
}
