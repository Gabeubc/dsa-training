impl Solution {
    pub fn encode(strs: Vec<String>) -> String {
        let mut res=String::new();
        for s in strs{
            res.push_str(&format!("{};{}", s.len(), s));
        }
        return res;
    }

    pub fn decode(s: String) -> Vec<String> {
                    println!("{}",s);
        let mut res:Vec::<String>=Vec::new();
        let len=s.len();
        let sep=";";
        let mut start=0;
        while start<len{
            let op_sep_pos: Option<usize>=s[start..len].find(sep);
            if let Some(sep_pos)=op_sep_pos{
                    let op_curr_str_len: Result<i32, _>=s[start..start+sep_pos].parse();
                if let Ok(curr_str_len)=op_curr_str_len{
                    let start_curr_str=start+sep_pos+1;
                    let end_curr_str=start_curr_str+(curr_str_len as usize);
                    let curr_str=s[start_curr_str..end_curr_str].to_string();
                    res.push(curr_str);
                    start=end_curr_str; 
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
