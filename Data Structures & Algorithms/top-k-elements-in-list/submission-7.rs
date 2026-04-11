impl Solution {

    pub fn top_k_frequent(nums: Vec<i32>, k: i32) -> Vec<i32> {
        let n=nums.len();
        let mut freqs=HashMap::new();
        for &num in &nums{
            *freqs.entry(num).or_insert(0)+=1;
        }
        let mut bucket: Vec<Vec<i32>> = vec![vec![]; n + 1];
        for (el, freq) in freqs{
            bucket[freq as usize].push(el);
        }
        let mut res=Vec::new();
        for i in (0..=n).rev(){
            for num in &bucket[i]{
                res.push(*num);
                if res.len()==k as usize{
                    return res;
                }
            }
        }
        return res;
    }
}
