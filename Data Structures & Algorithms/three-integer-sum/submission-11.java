class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int len=nums.length;
        List<List<Integer>> res=new LinkedList();
        Arrays.sort(nums);
        for(int i=0; i<len-2; i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int target=-nums[i];
            int l=i+1;
            int r=len-1;
            while(l<r){
                int sum=nums[l]+nums[r];
                if(target==sum){
                    res.add(List.of(nums[l], nums[r], -target));
                    while(l<r && nums[l]==nums[l+1]) l++;
                    while(l<r && nums[r]==nums[r-1]) r--;
                    l++;
                    r--;
                }else if(sum<target){
                    l++;
                }else{
                    r--;
                }
            }
        }
        return res;
    }
}
