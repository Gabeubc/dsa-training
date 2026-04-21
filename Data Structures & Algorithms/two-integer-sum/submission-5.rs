impl Solution {
    pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
        let mut complements:HashMap<i32, usize> = HashMap::new();
        for (i, &num) in nums.iter().enumerate(){
            let complement=target-num;
            if let Some(&pos)=complements.get(&complement){
                return vec![pos as i32, i as i32];
            }
            complements.insert(num, i);
        }
        vec![]
    }
}