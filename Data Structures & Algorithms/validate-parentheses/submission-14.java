class Solution {
    public boolean isValid(String s) {
        int len=s.length();
        if(len==1) return false;
        Deque<Character> stack=new ArrayDeque<>();
        for(int i=0; i<len; i++){
            char c=s.charAt(i);
            switch(c){
                case ')':{
                    if(stack.isEmpty() || stack.pop()!='(') return false;
                    break;
                }
                case '}':{
                    if(stack.isEmpty() || stack.pop()!='{') return false;
                    break;
                }
                case ']':{
                    if(stack.isEmpty() || stack.pop()!='[') return false;
                    break;
                }
                default:{
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty();
    }
}
