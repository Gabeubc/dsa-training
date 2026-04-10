impl Solution {
    pub fn is_anagram(s: String, t: String) -> bool {
        if s.len()!=t.len(){
            return false;
        }
        let mut counts=[0;26];
        for ascii in s.bytes(){
            let pos=ascii%26;
            counts[pos as usize]+=1;
        }
        for ascii in t.bytes(){
            let pos=ascii%26;
            counts[pos as usize]-=1;
            if counts[pos as usize]<0 {
                return false;
            }
        }
        return true;
    }
}
