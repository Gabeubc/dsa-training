use std::collections::{BinaryHeap, HashMap};
use std::cmp::Ordering;

// 1. La struct et ses traits doivent être définis en dehors de impl Solution
#[derive(Eq, PartialEq)]
struct Element {
    key: i32,
    priority: i32,
}

impl Ord for Element {
    fn cmp(&self, other: &Self) -> Ordering {
        self.priority.cmp(&other.priority)
    }
}

impl PartialOrd for Element {
    fn partial_cmp(&self, other: &Self) -> Option<Ordering> {
        Some(self.cmp(other))
    }
}

impl Solution {

    pub fn top_k_frequent(nums: Vec<i32>, k: i32) -> Vec<i32> {
        let mut pq=BinaryHeap::new();
        let mut freqs=HashMap::new();
        for num in nums{
            let mut freq=freqs.get(&num).unwrap_or(&0);
            freqs.insert(num, freq+1);
        }
        for (key, priority) in freqs{
            pq.push(Element{key: key, priority:priority});
        }
        let mut res=Vec::new();
        for _ in 0..k {
            if let Some(el)=pq.pop(){
                res.push(el.key);
            }
        }
        return res;
    }
}
