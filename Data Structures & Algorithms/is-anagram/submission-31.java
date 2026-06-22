class Solution {
    public boolean isAnagram(String s, String t) {
        int s_length=s.length();
        int t_length=t.length();
        if(s_length!=t_length) return false;
        Map<Character, Integer> freqs=new HashMap<>();
        for(int i=0; i<s_length; i++){
            char c=s.charAt(i);
            int freq=freqs.getOrDefault(c, 0);
            freqs.put(c, freq+1);
        }
        for(int i=0; i<t_length; i++){
            char c=t.charAt(i);
            int freq=freqs.getOrDefault(c, 0);
            if(freq==0) return false;
            freqs.put(c, freq-1);
        }
        return true;
    }
}
