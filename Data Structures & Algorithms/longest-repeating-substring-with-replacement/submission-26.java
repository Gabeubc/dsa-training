class Solution {
    public int characterReplacement(String s, int k) {
        int len=s.length();
        int l=0;
        int max=0;
        Map<Character, Integer> freqs=new HashMap<>();
        for(int r=0; r<len; r++){
            int freq=freqs.getOrDefault(s.charAt(r), 0)+1;
            freqs.put(s.charAt(r), freq);
            max=Math.max(max, freq);
            while((r-l+1)-max>k){
                freqs.put(s.charAt(l), freqs.get(s.charAt(l))-1);
                l++;
            }
        }
        return len-l;
    }
}
