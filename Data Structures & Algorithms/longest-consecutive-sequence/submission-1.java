class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        int l=nums.length;
        int max=0;
        int count=1;
        Arrays.sort(nums);
        for(int i=1; i<l; i++){
            if(nums[i]!=nums[i-1])
            if(nums[i]==nums[i-1]+1){
                count++;
            }else{
                max=Math.max(count, max);
                count=1;
            }
        }
        return Math.max(count, max);
    }
}
