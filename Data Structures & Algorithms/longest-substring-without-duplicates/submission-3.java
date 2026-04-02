class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        Queue<Character> sub=new LinkedList<Character>();
        int r=0;
        int max=1;
        char[] sArray=s.toCharArray();
        sub.add(sArray[0]);
        for(int i=1; i<sArray.length; i++){
            if(sub.contains(sArray[i])){
                max=Math.max(max, sub.size());
                while(sub.contains(sArray[i])){
                    sub.remove();
                }
            }
            sub.add(sArray[i]);
        }
        return max=Math.max(max, sub.size());
    }
}
