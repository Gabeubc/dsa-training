class Solution {
    public int longestConsecutive(int[] nums) {
        int len=nums.length;
        int max=0;
        Set<Integer> set=new HashSet<Integer>();
        for(int num:nums){
            set.add(num);
        }
        for(int i=0; i<len; i++){
            int curr=nums[i];
            if(!set.contains(curr-1)){
                int count=0;
                while(set.contains(curr++)) count++;
                max=Math.max(count, max);
            }
        }
        return max;
    }
}
