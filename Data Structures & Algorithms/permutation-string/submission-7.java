class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l1=s1.length();
        int l2=s2.length();
        int l=0;
        Map<Character, Integer> freqs1=new HashMap<>();
        for(int i=0; i<l1; i++){
            char c=s1.charAt(i);
            freqs1.put(c, freqs1.getOrDefault(c, 0)+1);
        }
        int conditionToFit=freqs1.size();
        Map<Character, Integer> freqs2=new HashMap<>();
        int countCondition=0;
        for(int r=0; r<l2; r++){
            char c=s2.charAt(r);
            if(freqs1.containsKey(c)){
                int freq=freqs2.getOrDefault(c, 0)+1;
                freqs2.put(c, freq);
                if(freq==freqs1.get(c)){
                    countCondition++;
                }
            }
            while(countCondition==conditionToFit){
                c=s2.charAt(l);
                if(freqs1.containsKey(c)){
                    int freq=freqs2.get(c)-1;
                    freqs2.put(c, freq);
                    if(freq<freqs1.get(c)) countCondition--;
                }
                if(r-l+1==l1) return true;
                l++;
            }
        }
        return false;
    }
}
