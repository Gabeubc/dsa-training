class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb=new StringBuilder();
        for(String str: strs){
            sb.append(str.length()).append(";").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res=new ArrayList<>();
        for(int i=0; i<str.length(); i++){
            int sepIndex=str.indexOf(';', i);
            int len=Integer.parseInt(str.substring(i, sepIndex));
            String resItem=str.substring(sepIndex+1, sepIndex+1+len);
            res.add(resItem);
            i=sepIndex+len;
        }
        return res;
    }
}
