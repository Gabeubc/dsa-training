class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int l = nums.length;
        for(int i=0; i<l-2; i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int left=i+1;
            int right= l-1;
            int target=-nums[i];
            while(left<right){
                int sum=nums[left]+nums[right];
                if(target==sum){
                    res.add(Arrays.asList(nums[left],  nums[right], -target));
                    while(left<right && nums[left]==nums[left+1]) left++;
                    while(left<right && nums[right]==nums[right-1]) right--;
                    left++;
                    right--;
                }else if(sum<target){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return res;
    }
}
