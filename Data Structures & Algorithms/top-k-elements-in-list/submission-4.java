class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(k>nums.length) return new int[0];
        int[] res=new int[k];
        Map<Integer, Integer> freqs=new HashMap<>();
        for(int i=0; i<nums.length; i++){
            freqs.put(nums[i], freqs.getOrDefault(nums[i], 0)+1);
        }
        List<Integer> orderedFreq=new ArrayList<>(freqs.values());
        Collections.sort(orderedFreq, Collections.reverseOrder());
        for(int i=0; i<k; i++){
            int max=orderedFreq.get(i);
            for(Map.Entry<Integer, Integer> e: freqs.entrySet()){
                if(e.getValue()==max){
                    res[i]=e.getKey();
                    freqs.remove(e.getKey());
                    break;
                }
            }
        }
        return res;
    }
}
