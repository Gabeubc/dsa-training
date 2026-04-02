class Solution {
    public int findMin(int[] nums) {
        int len=nums.length-1;
        if(nums.length==1) return nums[0]; 
        int l=0;
        int r=len;
        int mid=0;
        while(l<=r){
            mid = l+(r-l)/2;
            if(nums[mid]>nums[r]) l=mid+1;
            else if(nums[mid]>nums[l]) r=mid-1;
            else if(mid<len-1 && nums[mid]>nums[mid+1]) l=mid;
            else if(mid>0 && nums[mid]>nums[mid-1]) r=mid;
            else break;
        }
        return nums[mid];
    }
}
