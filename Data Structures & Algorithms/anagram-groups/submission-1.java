class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> freqs=new HashMap<>();
        for(String str: strs){
            char[] strArray = str.toCharArray();
            Arrays.sort(strArray);
            freqs.computeIfAbsent(String.valueOf(strArray), v->new ArrayList<>()).add(str);
        }
        return List.copyOf(freqs.values());
    }
}
