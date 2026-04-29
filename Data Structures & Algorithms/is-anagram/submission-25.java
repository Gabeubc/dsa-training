class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] freqs=new int[26];
        for(char c:s.toCharArray()){
            int pos=((int)c)%26;
            freqs[pos]+=1;
        }
        for(char c:t.toCharArray()){
            int pos=((int)c)%26;
            freqs[pos]-=1;
            if(freqs[pos]<0){
                return false;
            }
        }
        return true;
    }
}
