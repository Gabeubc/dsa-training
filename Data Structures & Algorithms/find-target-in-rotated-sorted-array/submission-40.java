class Solution {
    public int search(int[] nums, int target) {
        int len=nums.length;
        int l=0;
        int r=len-1;
        if(len==1) return target==nums[0]?0:-1;
        while(l<r){
            int mid=l+(r-l)/2;
            if(nums[r]<nums[mid]){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        int pivot=l-1;
        r=len-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        l=0;
        r=pivot;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return -1;
    }
}
