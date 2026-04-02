class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len=nums.length;
        int[] lToRProduct=new int[len];
        int[] rToLProduct=new int[len];
        int[] res=new int[len];
        lToRProduct[0]=1;
        rToLProduct[len-1]=1;
        for(int i=1, j=len-2; i<len; i++, j--){
            lToRProduct[i]=lToRProduct[i-1]*nums[i-1];
            rToLProduct[j]=rToLProduct[j+1]*nums[j+1];
        }
        for(int i=0; i<len; i++){
            res[i]=lToRProduct[i]*rToLProduct[i];
        }
        return res;
    }
}  
