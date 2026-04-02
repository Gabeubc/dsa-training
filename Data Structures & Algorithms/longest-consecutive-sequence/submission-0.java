class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        Set<Integer> set=new HashSet<Integer>();
        for(int num: nums) set.add(num);
        int l=nums.length;
        int max=0;
        for(int i=0; i<l; i++){
            int curr=nums[i];
            if(!set.contains(curr-1)){
                int count=0;
                while(set.contains(curr++)) count++;
                if(max<count) max=count;
                count=0;
            }
        }
        return max;
    }
}
