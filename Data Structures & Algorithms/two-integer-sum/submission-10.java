class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> complements=new HashMap<>();
        int len=nums.length;
        for(int i=0; i<len; i++){
            int complement=target-nums[i];
            if(complements.containsKey(complement)) return new int[]{complements.get(complement), i};
            complements.put(nums[i], i);
        }
        return new int[2];
    }
}
