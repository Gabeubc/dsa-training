class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqs=new HashMap();
        int len=nums.length;
        List<Integer>[] buckets=new LinkedList[len+1];
        int[] res=new int[k];
        for(int i=1; i<len+1; i++){
            buckets[i]=new LinkedList();
        }
        for(int num:nums){
            freqs.put(num, freqs.getOrDefault(num, 0)+1);
        }
        for(Map.Entry<Integer, Integer> e:freqs.entrySet()){
            buckets[e.getValue()].add(e.getKey());
        }
        int count=0;
        for(int i=len; i>0 && count<k; i--){
            for(int num:buckets[i]){
                res[count++]=num;
                if(count==k) return res;
            }
        }
        return res;
    }
}
