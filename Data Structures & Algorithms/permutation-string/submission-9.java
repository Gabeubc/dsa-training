class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l1=s1.length();
        int[] count1=new int[26];
        for(int i=0; i<l1; i++){
            count1[s1.charAt(i)-'a']++;
        }
        int l2=s2.length();
        int[] count2=new int[26];
        int l=0;
        for(int r=0; r<l2; r++){
            int idx=s2.charAt(r)-'a';
            count2[idx]++;
            if(r-l+1==l1){
                boolean inclusion=true;
                for(int i=0; i<26; i++){
                    if(count1[i]!=count2[i]){
                        inclusion=false;
                        break;
                    }
                }
                if(inclusion) return true;
                count2[s2.charAt(l++)-'a']--;
            }
        }
        return false;
    }
}
