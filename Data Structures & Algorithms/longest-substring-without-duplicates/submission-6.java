class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> sub=new HashSet<Character>();
        int l=0;
        int max=0;
        for(int r=0; r<s.length(); r++){
            if(sub.contains(s.charAt(r))){
                while(sub.contains(s.charAt(r))){
                    sub.remove(s.charAt(l));
                    l++;
                }
            }
            sub.add(s.charAt(r));
            max=Math.max(max, r-l+1);
        }
        return max;
    }
}
