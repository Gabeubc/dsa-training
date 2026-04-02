class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> freq = new HashMap<>();
        for(String str: strs){
            char[] strArray = str.toCharArray();
            Arrays.sort(strArray);
            String tmp = String.valueOf(strArray);
            freq.computeIfAbsent(tmp, v->new ArrayList<>()).add(str);
        }
        return freq
                    .values()
                    .stream()
                    .collect(Collectors.toList());
    }
}
