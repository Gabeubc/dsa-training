class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res=new LinkedList<>();
        combinationSumHelper(nums, target, 0, new LinkedList<>(), res, 0);
        return res;
    }
    private void combinationSumHelper(int[] nums, int target, int start, List<Integer> item, List<List<Integer>> res, int sum){
        if(sum>target || start>nums.length){
            return;
        }
        if(sum==target){
            res.add(new ArrayList<>(item));
            return;
        }
        for(int i=start; i<nums.length; i++){
            item.add(nums[i]);
            combinationSumHelper(nums, target, i, item, res, sum+nums[i]);
            if(item.size()>0) item.removeLast();
        }
    }
}
