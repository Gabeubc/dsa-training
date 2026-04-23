impl Solution {
    pub fn length_of_longest_substring(s: String) -> i32 {
        let mut l:usize=0;
        let mut r:usize=0;
        let s_vec:Vec<char>=s.chars().collect();
        let len:usize=s_vec.len();
        let mut max:i32=0;
        let mut set:HashSet<char>=HashSet::new();
        while r<len{
            while r<len && !set.contains(&s_vec[r]){
                set.insert(s_vec[r]);
                r+=1;
            }
            max=max.max(set.len() as i32);
            set.clear();
            l+=1;
            r=l;
        }
        return max;
    }
}
