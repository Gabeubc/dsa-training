class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int len=nums.length;
        List<Integer>[] buckets=new ArrayList[len+1];
        for(int i=1; i<len+1; i++){
            buckets[i]=new ArrayList<>();
        }
        Map<Integer, Integer> freqs=new HashMap<>();
        for(int num:nums){
            int freq=freqs.getOrDefault(num, 0);
            freqs.put(num, freq+1);
        }
        for(Map.Entry<Integer, Integer> e:freqs.entrySet()){
            buckets[e.getValue()].add(e.getKey());
        }
        int j=0;
        int[] res=new int[k];
        for(int i=len; i>0; i--){
            List<Integer> bucket=buckets[i];
            for(int num:bucket){
                res[j++]=num;
                if(j==k) return res;
            }
        }
        return res;
    }
}
