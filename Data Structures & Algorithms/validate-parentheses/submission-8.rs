impl Solution {
    pub fn is_valid(s: String) -> bool {
        let mut stack:VecDeque<char>=VecDeque::new();
        let opened_parentheses=vec!['(','[','{'];
        let mut s_chars:Vec<char>=s.chars().collect();
        if !opened_parentheses.contains(&s_chars[0]){
            return false;
        }
        let len=s_chars.len();
        for i in 0..len{
            let parenthese=s_chars[i];
            match parenthese {
                ')' => if stack.pop_back() != Some('(') { return false; },
                ']' => if stack.pop_back() != Some('[') { return false; },
                '}' => if stack.pop_back() != Some('{') { return false; },
                _   => stack.push_back(parenthese), 
            }
        }
        return stack.is_empty();
    }
}
