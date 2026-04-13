impl Solution {
    pub fn encode(strs: Vec<String>) -> String {
        let mut res = String::new();
        for s in strs {
            res.push_str(&format!("{};", s.len()));
            res.push_str(&s);
        }
        res
    }

    pub fn decode(s: String) -> Vec<String> {
        let mut res = Vec::new();
        let mut i = 0;
        let bytes = s.as_bytes();
        while i < s.len() {
            if let Some(pos_relativa) = s[i..].find(';') {
                let pos_punto_virgola = i + pos_relativa;
                if let Ok(len) = s[i..pos_punto_virgola].parse::<usize>() {
                    let start = pos_punto_virgola + 1;
                    let end = start + len;
                    res.push(s[start..end].to_string());
                    i = end;
                } else {
                    break; 
                }
            } else {
                break; 
            }
        }
        res
    }
}
