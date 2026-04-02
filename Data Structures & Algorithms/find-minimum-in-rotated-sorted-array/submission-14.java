class Solution {
    public int findMin(int[] nums) {
        int len=nums.length;
        int l=0;
        int r=len-1;
        if(nums[l]<=nums[r]) return nums[l];
        while(l<r){
            int mid=l+(r-l)/2;
            if(nums[mid]>nums[r]) l=mid+1;
            else r=mid;
        }
        return nums[l];
    }
}
