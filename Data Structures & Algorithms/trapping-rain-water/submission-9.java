class Solution {
    public int trap(int[] height) {
        int len=height.length;
        int[] l_to_r=new int[len];
        int[] r_to_l=new int[len];
        int max=0;
        for(int i=1; i<len; i++){
            max=Math.max(height[i-1], max);
            l_to_r[i]=max;
        }
        max=0;
        for(int i=len-2; i>=0; i--){
            max=Math.max(height[i+1], max);
            r_to_l[i]=max;
        }
        for(int i:r_to_l){
            System.out.println(i);
        }
        int res=0;
        for(int i=1; i<len-1; i++){
            int val=Math.min(l_to_r[i], r_to_l[i])-height[i];
            if(val>0){ 
                res+=val;
            }
        }
        return res;
    }
}
