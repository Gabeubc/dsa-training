class Solution {
    public int evalRPN(String[] tokens) {
        int len=tokens.length;
        Deque<String> operands=new ArrayDeque<>();
        for(int i=0; i<len; i++){
            String s=tokens[i];
            switch(s){
                case "+":{
                    int o2=Integer.parseInt(operands.pop());
                    int o1=Integer.parseInt(operands.pop());
                    operands.push(String.valueOf(o1+o2));
                    break;
                }
                case "-":{
                    int o2=Integer.parseInt(operands.pop());
                    int o1=Integer.parseInt(operands.pop());
                    operands.push(String.valueOf(o1-o2));
                    break;
                }
                case "*":{
                    int o2=Integer.parseInt(operands.pop());
                    int o1=Integer.parseInt(operands.pop());
                    operands.push(String.valueOf(o1*o2));
                    break;
                }
                case "/":{
                    int o2=Integer.parseInt(operands.pop());
                    int o1=Integer.parseInt(operands.pop());
                    operands.push(String.valueOf(o1/o2));
                    break;
                }
                default:{
                    operands.push(String.valueOf(Integer.parseInt(s)));
                }
            }
        }
        return Integer.parseInt(operands.peek());
    }
}
