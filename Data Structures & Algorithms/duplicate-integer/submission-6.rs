impl Solution {
    pub fn has_duplicate(nums: Vec<i32>) -> bool {
        let mut set: HashSet::<&i32>=nums.iter().collect();
        return set.len()!=nums.len();
    }
}
