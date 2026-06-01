class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack=new ArrayDeque<>();
        int len=s.length();
        int i=0;
        while(i<len){
            char c=s.charAt(i);
            switch(c){
                case ']':{
                    if(stack.peek()==null || stack.peek()!='[') return false;
                    stack.pop();
                    break;
                }
                case '}':{
                    if(stack.peek()==null || stack.peek()!='{') return false;
                    stack.pop();
                    break;
                }
                case ')':{
                    if(stack.peek()==null || stack.peek()!='(') return false;
                    stack.pop();
                    break;
                }
                default:{
                    stack.push(c);
                    break;
                }
            }
            i++;
        }
        return stack.isEmpty();
    }
}
