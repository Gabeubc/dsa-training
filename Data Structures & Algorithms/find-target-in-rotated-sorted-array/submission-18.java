class Solution {
    public int search(int[] nums, int target) {
        int len=nums.length;
        if(len==1 && nums[0]==target) return 0;
        else if(len==1 && nums[0]!=target) return -1;
        int l=0;
        int r=len-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]==target) return mid;
            if(nums[l]<=nums[mid]){
                if(target>=nums[l] && target<nums[mid]){
                    r=mid-1;
                }else{
                    l=mid+1;
                }
            }else{
                if(target>nums[mid] && target<=nums[r]){
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }
        }
        return -1;
    }
}
