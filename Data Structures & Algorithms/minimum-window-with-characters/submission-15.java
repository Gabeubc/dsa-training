class Solution {
    public String minWindow(String s, String t) {
        int l_s=s.length();
        int l_t=t.length();
        int l=0;
        Map<Character, Integer> freq_t=new HashMap<>();
        for(int i=0; i<l_t; i++){
            char c=t.charAt(i);
            int freq=freq_t.getOrDefault(c, 0)+1;
            freq_t.put(c, freq);
        }
        int conditionToFit=freq_t.size();
        Map<Character, Integer> freq_s=new HashMap<>();
        int countConditionFit=0;
        int min=Integer.MAX_VALUE;
        String res="";
        for(int r=0; r<l_s; r++){
            char c=s.charAt(r);
            if(freq_t.containsKey(c)){
                int freq=freq_s.getOrDefault(c, 0)+1;
                freq_s.put(c, freq);
                if(freq==freq_t.get(c)){
                    countConditionFit++;
                }
            }
            while(countConditionFit==conditionToFit){
                c=s.charAt(l);
                if(freq_t.containsKey(c)){
                    int freq=freq_s.get(c)-1;
                    freq_s.put(c, freq);
                    if(freq<freq_t.get(c)){
                        countConditionFit--;
                        if(min>r-l+1){
                            min=r-l+1;
                            res=s.substring(l, r+1);
                        }
                    }
                }
                l++;
            }
        }
        return res;
    }
}
