class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupedAnagrams=new HashMap();
        for(String s:strs){
            int[] count=new int[26];
            for(char c:s.toCharArray()){
                int pos=c-'a';
                count[pos]++;
            }
            String key=Arrays.toString(count);
            groupedAnagrams.computeIfAbsent(
                key,
                k->new LinkedList()
            ).add(s);
        }
        return List.copyOf(groupedAnagrams.values());
    }
}
