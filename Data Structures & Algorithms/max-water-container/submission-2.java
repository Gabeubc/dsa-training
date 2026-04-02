class Solution {
    public int maxArea(int[] heights) {
        int l=0;
        int r=heights.length-1;
        int max=Integer.MIN_VALUE;;
        while(l<r){
            int lH=heights[l];
            int rH=heights[r];
            int h=Math.min(lH,rH);
            max=Math.max((r-l)*h, max);
            if(h==lH){
                l++;
            }else{
                r--;
            }
        }
        return max;
    }
}
