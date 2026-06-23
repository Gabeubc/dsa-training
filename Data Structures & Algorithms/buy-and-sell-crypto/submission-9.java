class Solution {
    public int maxProfit(int[] prices) {
        int len=prices.length;
        int l=0;
        int max=0;
        for(int r=0; r<len; r++){
            if(prices[r]<prices[l]) l=r;
            else{
                max=Math.max(max, prices[r]-prices[l]);
            }
        }
        return max;
    }
}
