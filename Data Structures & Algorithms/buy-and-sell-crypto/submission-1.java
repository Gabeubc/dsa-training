class Solution {
    public int maxProfit(int[] prices) {
        int l=0;
        int r=1;
        int max=0;
        int len=prices.length;
        while(r<len){
            int newPrice=prices[r];
            if(newPrice<prices[l]){
                l=r;
            }else{
                max=Math.max(max, newPrice-prices[l]);
            }
            r++;
        }
        return max;
    }
}
