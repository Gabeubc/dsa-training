class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";
        int freq=t.length();
        int l=0;
        String res = new String();
        int minLen = Integer.MAX_VALUE;
        Map<Character, Integer> freqS=new HashMap<Character, Integer>();
        Map<Character, Integer> freqT=new HashMap<Character, Integer>();
        for(char c: t.toCharArray()){
            freqT.put(c, freqT.getOrDefault(c, 0)+1);
        }
        for(int r=0; r<s.length(); r++){
            char c = s.charAt(r);
            freqT.computeIfPresent(c, (k, v)->{
                freqS.put(k, freqS.getOrDefault(k, 0)+1);
                return v;
            });
            while(freqT.keySet().stream().allMatch(k->freqS.getOrDefault(k, 0)>=freqT.get(k))){
                c = s.charAt(l);
                if(freqT.containsKey(c)){
                    freqS.put(c, freqS.get(c)-1);
                    if(minLen>(r-l+1)){
                        res = s.substring(l, r+1);
                        minLen=res.length();
                    }
                }
                l++;
            }
        }
        return res;
    }
}
