class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0)=='0') return 0; 
        int len=s.length();
        int[] dp=new int[len+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2; i<len+1; i++){
            int curr=s.charAt(i-1)-'0';
            int prev=s.charAt(i-2)-'0';
            int combined=prev*10+curr;
            if(curr>0){
                dp[i]+=dp[i-1];
            }
            if(10<=combined && combined<=26){
                dp[i]+=dp[i-2];
            }
        }
        return dp[len];
    }
}
