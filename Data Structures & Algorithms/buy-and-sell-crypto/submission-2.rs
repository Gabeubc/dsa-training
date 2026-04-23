impl Solution {
    pub fn max_profit(prices: Vec<i32>) -> i32 {
        let mut l=0;
        let mut r=1;
        let mut max=0;
        let len=prices.len();
        while r<len{
            if prices[r]<prices[l]{
                l=r
            }else{
                max=max.max(prices[r]-prices[l]);
            }
            r+=1;
        }
        return max;
    }
}
