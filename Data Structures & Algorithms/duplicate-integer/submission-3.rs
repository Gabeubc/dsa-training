impl Solution {
    pub fn has_duplicate(nums: Vec<i32>) -> bool {
        let mut set = HashSet::new(); 
        for i in &nums{
            set.insert(i);
        }
        return set.len()!=nums.len();
    }
}
