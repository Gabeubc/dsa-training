class Solution {
    public int maxArea(int[] heights) {
        int len=heights.length;
        int l=0;
        int maxHeight=heights[0];
        int maxArea=0;
        for(int r=1; r<len; r++){
            while(l<r){
                maxArea=Math.max(maxArea, area(r-l, heights[l], heights[r]));
                l++;
            }
            l=0;
        }
        return maxArea;
    }
    public int area(int b, int h1, int h2){
        return b*Math.min(h1, h2);
    }
}
