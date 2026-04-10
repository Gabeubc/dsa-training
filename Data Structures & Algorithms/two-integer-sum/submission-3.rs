impl Solution {
    pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
        let mut remains = HashMap::new();
        for (i, &num) in nums.iter().enumerate() {
            remains.insert(num, i);
        }
        for (i, &num) in nums.iter().enumerate() {
            let complement = target - num;
            
            if let Some(&pos_remain) = remains.get(&complement) {
                if pos_remain != i {
                    return vec![i as i32, pos_remain as i32];
                }
            }
        }
        vec![]
    }
}