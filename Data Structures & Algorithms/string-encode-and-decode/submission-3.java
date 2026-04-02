class Solution {

    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        for(String str: strs){
            int l = str.length();
            builder.append(l);
            builder.append(";");
            builder.append(str);
        }
        return builder.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i=0;
        int strLength = str.length();
        while(i<strLength){
            int j = str.indexOf(";", i);
            int l = Integer.parseInt(str.substring(i, j));
            i=j+1;
            res.add(str.substring(i, i+l));
            i+=l;
        }
        return res;
    }
}
