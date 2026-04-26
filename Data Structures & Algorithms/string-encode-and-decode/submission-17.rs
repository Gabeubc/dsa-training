impl Solution {
    pub fn encode(strs: Vec<String>) -> String {
        let mut res=String::new();
        for s in strs{
            res.push_str(&(format!("{};{}", s.len(), s)));
        }
        return res;
    }

    pub fn decode(s: String) -> Vec<String> {
        println!("{}",s);
        let mut res:Vec::<String>=Vec::new();
        let mut cursor=0;
        let s_chars:Vec<char>=s.chars().collect();
        let len=s_chars.len();
        while cursor<len{
            if let Some(pos_of_sep)=(&s[cursor..len]).find(";"){
                let pos_of_sep=pos_of_sep as usize;
                let size_of_curr_str=(&s[cursor..cursor+pos_of_sep]).to_string();
                if let Ok(size_of_curr)=size_of_curr_str.parse::<usize>(){
                    let start_curr_str_pos=cursor+pos_of_sep+1 as usize;
                    let end_curr_str_pos=start_curr_str_pos+size_of_curr as usize;
                    if &s[start_curr_str_pos..end_curr_str_pos]==";"{
                        println!("---{}", pos_of_sep);
                        println!("--{}", size_of_curr_str);
                        println!("-{}",start_curr_str_pos);
                    }
                    res.push((&s[start_curr_str_pos..end_curr_str_pos]).to_string());
                    cursor=end_curr_str_pos;
                }else{
                    return res;
                }
            }else{
                return res;
            }
            
        }
        return res;
    }
}
