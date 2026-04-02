class Solution {
    public int findMin(int[] nums) {
        int len=nums.length;
        int l=0;
        int r=len-1;
        int mid=0;
        int res=nums[l];
        while(l<=r){
            if(nums[l]<nums[r]){
                res=Math.min(nums[l], res);
                break;
            }
            mid = (l+r)/2;
            res=Math.min(nums[mid], res);
            if(nums[l]<=nums[mid]) l=mid+1;
            else r=mid-1;
        }
        return res;
    }
}
