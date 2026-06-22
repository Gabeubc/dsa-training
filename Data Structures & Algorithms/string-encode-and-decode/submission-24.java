class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb=new StringBuilder();
        for(String str:strs){
            sb
                .append(str.length())
                .append("-")
                .append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        int len=str.length();
        if(len==0) return List.of();
        List<String> res=new LinkedList();
        int start=0;
        while(start<len){
            int sep_pos=str.indexOf("-", start);
            String size_str=str.substring(start, sep_pos);
            int size=Integer.parseInt(size_str);
            String item=str.substring(sep_pos+1, sep_pos+size+1);
            res.add(item);
            start=sep_pos+size+1;
        }
        return res;
    }
}
