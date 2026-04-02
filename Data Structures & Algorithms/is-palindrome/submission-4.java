class Solution {
    public boolean isPalindrome(String s) {
        int l=s.length();
        int right=0;
        int left=l-1;
        char[] sArray=s.toLowerCase().toCharArray();
        while(right<left){
            while(right<left && !Character.isLetterOrDigit(sArray[right])) right++;
            while(right<left && !Character.isLetterOrDigit(sArray[left])) left--;
            if(right<left && sArray[right]!=sArray[left]) return false;
            right++;
            left--;
        }
        return true;
    }
}
