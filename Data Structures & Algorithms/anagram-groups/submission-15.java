class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> bucket=new HashMap<>();
        int len=strs.length;
        for(int i=0; i<len; i++){
            String str=strs[i];
            int str_len=str.length();
            int[] count=new int[26];
            for(int j=0; j<str_len; j++){
                char c=str.charAt(j);
                count[c-'a']++;
            }
            String key=Arrays.toString(count);
            List<String> group=bucket.computeIfAbsent(key, k->new LinkedList<>());
            group.add(str);
        }
        return List.copyOf(bucket.values());
    }
}
