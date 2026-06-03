class TimeMap {

    record TimeKey(
        String key,
        int timestamp
    ){}

    private Map<TimeKey, String> map;

    public TimeMap() {
        map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        TimeKey k=new TimeKey(key, timestamp);
         map.put(k, value);
    }
    
    public String get(String key, int timestamp) {
        List<TimeKey> keys=map
        .keySet()
        .stream()
        .filter(k->k.key.equals(key))
        .collect(Collectors.toList());
        Collections.sort(keys,(a,b)->Integer.compare(a.timestamp, b.timestamp));
        int l=0;
        int r=keys.size()-1;
        TimeKey max=null;
        while(l<=r){
            int mid=l+(r-l)/2;
            TimeKey k=keys.get(mid);
            if(timestamp>=k.timestamp){
                l=mid+1;
                max=new TimeKey(key, k.timestamp);
            }else{
                r=mid-1;
            }
        }
        return max==null?"":map.get(max);
    }
}
