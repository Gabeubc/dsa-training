class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freqs=new HashMap<>();
        int max=-1;
        int l=0;
        int res=0;
        for(int r=0; r<s.length(); r++){
            int freq=freqs.getOrDefault(s.charAt(r), 0)+1;
            freqs.put(s.charAt(r), freq);
            max=Math.max(freq, max);
            while((r-l+1)-max>k && l<s.length()) {
                freq=freqs.get(s.charAt(l));
                freqs.put(s.charAt(l), freq-1);
                l++;
            }
            res=Math.max(res, r-l+1);
        }
        return res;
    }
}
