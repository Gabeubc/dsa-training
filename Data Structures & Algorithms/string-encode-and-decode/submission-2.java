class Solution {

    public String encode(List<String> strs) {
        if(strs.isEmpty()) return null;
        StringBuilder builder = new StringBuilder();
        List<String> special = List.of("", " ", ";");
        for(String str: strs){
            if(str.equals("")){
                builder.append("empty_string");
            }else if(str.equals(" ")){
                builder.append("space");
            }else if(str.equals(";")){
                builder.append("semi-colon");
            }else builder.append(str);
            builder.append(";");
        }
        return builder.toString();
    }

    public List<String> decode(String str) {
        if(str==null) return List.of();
        return Arrays.stream(str.split(";")).map( it -> {
            if(it.equals("empty_string")){
                return "";
            }else if(it.equals("space")){
                return " ";
            }else if(it.equals("semi-colon")){
                return ";";
            }else return it;
        }).collect(Collectors.toList());
    }
}
