class Solution {
    public boolean isValid(String s) {
        int l=s.length();
        Deque<Character> stack=new ArrayDeque<Character>();
        for(int i=0; i<l; i++){
            char c=s.charAt(i);
                switch(c){
                    case '}':
                        if(stack.peek()!=null && stack.peek()=='{') stack.pop();
                        else return false;
                        break;
                    case ')':
                        if(stack.peek()!=null && stack.peek()=='(') stack.pop();
                        else return false;
                        break;
                    case ']':
                        if(stack.peek()!=null && stack.peek()=='[') stack.pop();
                        else return false;
                        break;
                    default:
                        stack.push(c);
                }
        }
        return stack.isEmpty();
    }
}
