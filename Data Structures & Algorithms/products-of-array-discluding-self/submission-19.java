class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len=nums.length;
        int[] l_to_r=new int[len];
        int[] r_to_l=new int[len];
        l_to_r[0]=1;
        r_to_l[len-1]=1;
        for(int i=1, j=len-2; i<len; i++, j--){
            l_to_r[i]=l_to_r[i-1]*nums[i-1];
            r_to_l[j]=r_to_l[j+1]*nums[j+1];
        }
        int[] res=new int[len];
        for(int i=0; i<len; i++){
            res[i]=l_to_r[i]*r_to_l[i];
        }
        return res;
    }
}  
