impl Solution {
    pub fn is_anagram(s: String, t: String) -> bool {
        let mut freq=HashMap::new();
        for c in s.chars(){
            *freq.entry(c).or_insert(0)+=1;
        }
        for c in t.chars(){
            *freq.entry(c).or_insert(0)-=1;
        }
        for (c, f) in freq{
            if f!=0{
                return false;
            }
        }
        return true;
    }
}
