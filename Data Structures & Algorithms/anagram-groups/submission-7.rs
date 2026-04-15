impl Solution {
    pub fn group_anagrams(strs: Vec<String>) -> Vec<Vec<String>> {
        let mut buckets: HashMap<Vec<u32>, Vec<String>>=HashMap::new();
        for s in strs{
            let mut dict=vec![0;26];
            for c in s.chars(){
                let i=(c as u32)%26;
                dict[i as usize]+=1;
            }
            buckets.entry(dict).or_insert(Vec::new()).push(s);
        }
        return buckets.into_values().collect();
    }
}
