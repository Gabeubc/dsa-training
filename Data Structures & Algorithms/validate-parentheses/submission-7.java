class Solution {
    public boolean isValid(String s) {
        char[] sArray=s.toCharArray();
        Deque<Character> stack=new ArrayDeque<Character>();
        for(char c: sArray){
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
