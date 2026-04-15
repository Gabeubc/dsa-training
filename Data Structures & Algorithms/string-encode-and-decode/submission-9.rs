impl Solution {
    pub fn encode(strs: Vec<String>) -> String {
        let mut res = String::new();
        let sep=';';
        for s in strs.iter(){
            res.push_str(&format!("{}{}{}",s.len(),&sep,&s));
        }
        res
    }

    pub fn decode(s: String) -> Vec<String> {
        let len=s.len();
        let sep=';';
        let mut res = Vec::new();
        let mut start_pos=0 as usize;
        while start_pos<len{
            if let Some(sep_pos)=s[start_pos..].find(sep){
                if let Ok(size)=s[start_pos..start_pos+sep_pos].parse::<usize>(){
                    res.push(s[start_pos+sep_pos+1..start_pos+sep_pos+1+size].to_string());
                    start_pos=start_pos+sep_pos+1+size;
                }else{
                    break;
                }
            }else{
                break;
            }
        }
        return res;
    }
}
