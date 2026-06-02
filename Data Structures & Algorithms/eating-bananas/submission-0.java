class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxP=0;
        for(int p:piles){
            maxP=Math.max(p, maxP);
        }
        int l=1;
        int r=maxP;
        int min=maxP;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(validRate(mid, piles)<=h){ 
                min=Math.min(mid, min);
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return min;
    }

    int validRate(int rate, int[] piles){
        int count=0;
        int len=piles.length;
        for(int p:piles){
            count+=Math.ceil((double)p/rate);
        }
        return count;
    }
}
