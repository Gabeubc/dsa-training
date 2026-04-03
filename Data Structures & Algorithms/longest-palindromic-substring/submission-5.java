class Solution {
    public String longestPalindrome(String s) {
        int len=s.length();
        int start=0, end=0;
        for(int i=0; i<len; i++){
            int l1=lenPalindrome(s, i, i);
            int l2=lenPalindrome(s, i, i+1);
            int maxLen=Math.max(l1, l2);
            if(maxLen>end-start+1){
                start=i-(maxLen-1)/2;
                end=i+maxLen/2;
            }
        }
        return s.substring(start, end+1);
    }
    private int lenPalindrome(String s, int l, int r){
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        return r-l-1;
    }
}
