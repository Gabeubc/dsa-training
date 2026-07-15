class Solution {
    public int findMin(int[] nums) {
        int res=0;
        int l=0;
        int r=nums.length-1;
        if(nums[l]<nums[r]) return nums[l];
        while(l<r){
            int mid=l+(r-l)/2;
            if(nums[r]<nums[mid]){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        return nums[l];
    }
}
