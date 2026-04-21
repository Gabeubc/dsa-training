impl Solution {
    pub fn group_anagrams(strs: Vec<String>) -> Vec<Vec<String>> {
        let mut res:HashMap<[i32;26], Vec<String>>=HashMap::new();
        for s in strs{
            res.entry(Self::compute_k(&s)).or_insert(Vec::new()).push(s);
        }
        return res.into_values().collect();
    }
    pub fn compute_k(s: &str)->[i32;26]{
        let mut res = [0;26];
        for ascii in s.as_bytes(){
            res[(ascii%26) as usize]+=1;
        }
        return res;
    }

}
