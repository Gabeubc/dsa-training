impl Solution {
    pub fn product_except_self(nums: Vec<i32>) -> Vec<i32> {
        let len = nums.len();
        let mut res = vec![1; len];
    
        let mut left_product = 1;
        for i in 0..len {
            res[i] = left_product;
            left_product *= nums[i];
        }
        
        let mut right_product = 1;
        for i in (0..len).rev() {
            res[i] *= right_product;
            right_product *= nums[i];
        }
        
        res
    }
}
