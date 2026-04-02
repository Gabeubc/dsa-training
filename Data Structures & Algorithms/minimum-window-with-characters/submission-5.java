class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";
        int freq=t.length();
        int l=0;
        int have=0;
        String res = new String();
        int minLen = Integer.MAX_VALUE;
        Map<Character, Integer> freqS=new HashMap<Character, Integer>();
        Map<Character, Integer> freqT=new HashMap<Character, Integer>();
        for(char c: t.toCharArray()){
            freqT.put(c, freqT.getOrDefault(c, 0)+1);
        }
        final int need=freqT.size();
        for(int r=0; r<s.length(); r++){
            char c = s.charAt(r);
            if(freqT.get(c)!=null){
                freqS.put(c, freqS.getOrDefault(c, 0)+1);
                if(freqS.get(c)==freqT.get(c)){
                    have++;
                }
                while(have==need){
                    c = s.charAt(l);
                    if(freqT.get(c)!=null){
                        freqS.put(c, freqS.get(c)-1);
                        if(freqS.get(c)<freqT.get(c)){
                            have--;
                        }
                        if(minLen>(r-l+1)){
                            res = s.substring(l, r+1);
                            minLen=res.length();
                        }
                    }
                    l++;
                }
            }
        }
        return res;
    }
}
