class TimeMap {

    record TimeValue(
        String value,
        int timestamp
    ){}

    private Map<String, List<TimeValue>> map;

    public TimeMap() {
        map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k->new ArrayList<>())
        .add(new TimeValue(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        List<TimeValue> values=map.get(key);
        if(values==null || values.size()==0) return "";
        int l=0;
        int r=values.size()-1;
        int idx=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            TimeValue value=values.get(mid);
            if(timestamp>=value.timestamp){
                idx=mid;
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return idx==-1?"":values.get(idx).value;
    }
}
