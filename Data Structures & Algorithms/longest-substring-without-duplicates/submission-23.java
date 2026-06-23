class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len=s.length();
        int l=0;
        Set<Character> set=new HashSet<>();
        int max=0;
        for(int r=0; r<len; r++){
            while(set.contains(s.charAt(r))) set.remove(s.charAt(l++));
            set.add(s.charAt(r));
            max=Math.max(max, set.size());
        }
        return max;
    }
}
