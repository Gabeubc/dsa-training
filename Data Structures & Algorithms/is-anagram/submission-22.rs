impl Solution {
    pub fn is_anagram(s: String, t: String) -> bool {
        if s.len()!=t.len(){
            return false;
        }
        let mut freqs:Vec<i32>=vec![0;26];
        let s_bytes=s.as_bytes();
        for &pos in s_bytes{
            freqs[(pos as usize)%26]+=1;
        }
        let t_bytes=t.as_bytes();
        for &pos in t_bytes{
            if freqs[(pos as usize)%26]==0{
                return false;
            }
            freqs[(pos as usize)%26]-=1;
        }
        return true;
    }
}
