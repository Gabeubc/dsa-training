use std::collections::HashMap;

impl Solution {
    pub fn min_window(s: String, t: String) -> String {
        let mut l=0;
        let mut target_freqs:HashMap::<char, i32>=HashMap::new();
        for c in t.chars(){
            *target_freqs.entry(c).or_insert(0)+=1;
        }
        let mut s_freqs:HashMap::<char, i32>=HashMap::new();
        let s_vec:Vec<char>=s.chars().collect();
        let s_len=s_vec.len();
        let mut have=0;
        let mut need=target_freqs.len();
        let mut min=usize::MAX;
        let mut res_range=(0, 0);
        for r in 0..s_len{
            let r_char=s_vec[r];
            if let Some(&target_count) = target_freqs.get(&r_char){
                 let r_char_s_freq=s_freqs.entry(r_char).or_insert(0);
                 *r_char_s_freq+=1;
                if *r_char_s_freq==target_count{
                    have+=1;
                }
            }
            while have==need{
                let len=r-l+1;
                if min>len{
                    min=len;
                    res_range=(l,r);
                }
                let l_char=s_vec[l];
                if let Some(&target_count) = target_freqs.get(&l_char){
                    let r_char_s_freq=s_freqs.get_mut(&l_char).unwrap();
                    if *r_char_s_freq==target_count{
                        have-=1;
                    }
                    *r_char_s_freq-=1;
                }
                l+=1;
            }
        }
        if min==usize::MAX{
            "".to_string()
        }else{
            (&s[res_range.0..=res_range.1]).to_string()
        }
    }
}
