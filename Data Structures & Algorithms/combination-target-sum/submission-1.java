class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res=new LinkedList<>();
        combinationSumHelper(nums, target, 0, new LinkedList<>(), res);
        return res;
    }
    private void combinationSumHelper(int[] nums, int target, int start, List<Integer> item, List<List<Integer>> res){
        int sum=item.stream().mapToInt(Integer::intValue).sum();
        if(sum==target){
            res.add(new ArrayList<>(item));
            return;
        }
        if(sum>target){
            return;
        }
        for(int i=start; i<nums.length; i++){
            item.add(nums[i]);
            combinationSumHelper(nums, target, i, item, res);
            if(item.size()>0) item.remove(item.size()-1);
        }
    }
}
