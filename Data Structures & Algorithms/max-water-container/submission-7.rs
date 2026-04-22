impl Solution {
    pub fn max_area(heights: Vec<i32>) -> i32 {
        let len=heights.len();
        let mut r=len-1 as usize;
        let mut l=0 as usize;
        let mut res=0;
        while l<r{
            res=(((r-l) as i32)*heights[l].min(heights[r])).max(res);
            if heights[l]<heights[r]{
                l+=1;
            }else{
                r-=1;
            }
        }
        return res;
    }
}
