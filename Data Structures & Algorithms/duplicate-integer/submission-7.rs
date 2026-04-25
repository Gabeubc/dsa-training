impl Solution {
    pub fn has_duplicate(nums: Vec<i32>) -> bool {
        let set:HashSet::<i32>=nums.iter().cloned().collect();
        return nums.len()!=set.len();
    }
}
