impl Solution {
    pub fn group_anagrams(strs: Vec<String>) -> Vec<Vec<String>> {
        let mut map: HashMap<[i32; 26], Vec<String>> = HashMap::new();
        for s in &strs{
            let mut dict = [0;26];
            for &c in s.as_bytes(){
                let pos=c%26;
               dict[pos as usize]+=1; 
            }
            if map.get(&dict).is_none(){
                map.insert(dict, Vec::new());
            }
        }
        
        for s in &strs{
            let mut dict = [0;26];
            for &c in s.as_bytes(){
                let pos=c%26;
               dict[pos as usize]+=1; 
            }
            if let Some(anagram)=map.get_mut(&dict){
                anagram.push(s.clone());
            }
        }
        return map.into_values().collect();
    }

}
