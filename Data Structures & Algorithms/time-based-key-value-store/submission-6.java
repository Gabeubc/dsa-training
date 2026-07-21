class TimeMap {

    record TimeMapDetail(
        String value,
        int timestamp
    ){}

    private Map<String, List<TimeMapDetail>> map;

    public TimeMap() {
        this.map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        this.map.computeIfAbsent(
            key,
            k->new ArrayList<>()
        ).add(new TimeMapDetail(
            value,
            timestamp
        ));
    }
    
    public String get(String key, int timestamp) {
        List<TimeMapDetail> details=map.getOrDefault(key, new ArrayList<>());
        int len=details.size();
        if(len==0) return "";
        int l=0;
        int r=len-1;
        String res="";
        while(l<=r){
            int mid=l+(r-l)/2;
            TimeMapDetail detail=details.get(mid);
            if(detail.timestamp<=timestamp){
                l=mid+1;
                res=detail.value;
            }else{
                r=mid-1;
            }
        }
        return res;
    }
}
