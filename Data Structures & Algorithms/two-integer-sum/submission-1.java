class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> complementCandidates=new HashMap<Integer, Integer>();
        complementCandidates.put(nums[0], 0);
        for(int i=1; i<nums.length; i++){
            int complement=target-nums[i];
            Integer candidateIndex=complementCandidates.get(complement);
            if(candidateIndex!=null){
                return new int[]{
                    candidateIndex,
                    i
                };
            }
            complementCandidates.put(nums[i], i);
        }
        return new int[0];
    }
}
