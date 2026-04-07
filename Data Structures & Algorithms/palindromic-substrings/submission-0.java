class Solution {
    public int countSubstrings(String s) {
        int res=0;
        for(int i=0; i<s.length(); i++){
            res+=countPalindrom(s, i, i);
            res+=countPalindrom(s, i, i+1);
        }
        return res;
    }
    public int countPalindrom(String s, int l, int r){
        int res=0;
        boolean fullHasBeenCounted=false;
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
            res++;
        }
        return res;
    }
}
