class Solution {
    public int longestConsecutive(int[] nums) {
        int len=nums.length;
        Set<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int max=0;
        for(int num:nums){
            if(!set.contains(num-1)){
                int count=0;
                while(set.contains(num)){
                    num++;
                    count++;
                }
                max=Math.max(count, max);
            }
        }
        return max;
    }
}
