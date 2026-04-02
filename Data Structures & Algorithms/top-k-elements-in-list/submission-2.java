class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num: nums){
            if(freq.containsKey(num)){
                int val = freq.get(num);
                if(val>max) max=val;
                freq.put(num, val+1);
            }else{
                freq.put(num, 1);
            }
        }
        List<Map.Entry<Integer, Integer>> listFreq = new ArrayList<>(freq.entrySet());
        listFreq.sort(Map.Entry.comparingByValue());
        int[] res = new int[k];
        int listFreqSize = listFreq.size()-1;
        for(int i=0; i<k; i++) res[i] = listFreq.get(listFreqSize-i).getKey();
        return res;
    }
}
