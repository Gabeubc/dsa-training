class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack=new ArrayDeque<>();
        int res=0;
        for(String s: tokens){
            switch(s){
                case "+":{
                    if(stack.size()>=2){
                        res=(stack.pop()+stack.pop());
                        stack.push(res);
                    }
                    break;
                }
                case "-":{
                    if(stack.size()>=2){
                        int a=stack.pop();
                        int b=stack.pop();
                        res=b-a;
                        stack.push(res);
                    }
                    break;
                }
                case "*":{
                    if(stack.size()>=2){
                        res=(stack.pop()*stack.pop());
                        stack.push(res);
                    }
                    break;
                }
                case "/":{
                    if(stack.size()>=2){
                        int a=stack.pop();
                        int b=stack.pop();
                        res=(b/a);
                        stack.push(res);
                    }
                    break;
                }
                default:{
                    stack.push(Integer.parseInt(s));
                }
            }
        }
        return stack.pop();
    }
}
