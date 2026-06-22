class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len=nums.length;
        List<List<Integer>> res=new LinkedList<>();
        for(int i=0; i<len-2; i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int target=-nums[i];
            int l=i+1; 
            int r=len-1;
            while(l<r){
                while(l<r && nums[l]+nums[r]<target) l++;
                while(l<r && nums[l]+nums[r]>target) r--;
                if(l!=r && nums[l]+nums[r]==target){ 
                    res.add(List.of(nums[i], nums[r], nums[l]));
                    while(l<r && nums[l]==nums[l+1]) l++;
                    while(l<r && nums[r]==nums[r-1]) r--;
                    l++;
                    r--;
                }
            }
        }
        return res;
    }
}
