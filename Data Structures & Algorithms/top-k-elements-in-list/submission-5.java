class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(k>nums.length) return new int[0];
        int[] res=new int[k];
        Map<Integer, Integer> freqs=new HashMap<>();
        for(int i=0; i<nums.length; i++){
            freqs.put(nums[i], freqs.getOrDefault(nums[i], 0)+1);
        }
        List<Map.Entry<Integer, Integer>> freqsList=new ArrayList<>(freqs.entrySet());
        freqsList.sort(Map.Entry.<Integer, Integer>comparingByValue().reversed());
        for(int i=0; i<k; i++){
            res[i]=freqsList.get(i).getKey();
        }
        return res;
    }
}
