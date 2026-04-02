class Solution {
    public int[] productExceptSelf(int[] nums) {
        boolean containZero = false; 
        int mult = 1;
        int countZero = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0 && !containZero) containZero=true;
            mult*=(nums[i]!=0?nums[i]:1);
            if(nums[i]==0) countZero++;
        }
        if(countZero>1) return new int[nums.length];
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=0 && containZero){
                nums[i]=0;
                continue;
            }
            if(nums[i]==0){
                nums[i]=mult;
                continue;
            }
            nums[i]=mult/nums[i];
        }
        return nums;
    }
}  
