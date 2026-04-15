impl Solution {
    pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
        let len=nums.len();
        let mut num_pos: HashMap::<i32, i32>=HashMap::new();
        for (i, &num) in nums.iter().enumerate(){
            let complement=target-num;
            if let Some(&pos)=num_pos.get(&complement){
                return vec![pos, i as i32];
            }
            num_pos.insert(num, i as i32);
        }
        return vec![];
    }
}
