class Solution {
    public int[] productExceptSelf(int[] nums) {
        int l=nums.length;
        int[] res=new int[l];
        res[0]=1;
        for(int i=1; i<l; i++){
            res[i]=nums[i-1]*res[i-1];
        }
        int suff=1;
        for(int i=l-1; i>=0; i--){
            res[i]=res[i]*suff;
            suff=suff*nums[i]; 
        }
        return res;
    }
}  
