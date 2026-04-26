impl Solution {
    pub fn product_except_self(nums: Vec<i32>) -> Vec<i32> {
        let len=nums.len();
        let mut l_to_r:Vec<i32>=vec![1;len];
        let mut r_to_l:Vec<i32>=vec![1;len];        
        let mut res:Vec<i32>=vec![1;len];
        for i in 1..len{
            l_to_r[i]=nums[i-1]*l_to_r[i-1];
        }
        for i in (0..len-1).rev(){
            r_to_l[i]=nums[i+1]*r_to_l[i+1];
        }
        for i in 0..len{
            res[i]=l_to_r[i]*r_to_l[i];
        }
        return res;
    }
}
