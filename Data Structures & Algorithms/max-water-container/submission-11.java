class Solution {
    public int maxArea(int[] heights) {
        int l=0;
        int r=heights.length-1;
        int max=0;
        while(l<r){
            int l_h=heights[l];
            int r_h=heights[r];
            int h=0;
            if(l_h<r_h){
                l++;
                h=l_h;
            }else{
                r--;
                h=r_h;
            }
            max=Math.max(max, (r-l+1)*h);
        }
        return max;
    }
}
